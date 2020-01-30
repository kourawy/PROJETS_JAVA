package plugin;

import plugin.file.FileChecker;
import plugin.file.FileEvent;
import plugin.filters.PluginFilter;
import plugin.listeners.FileListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * A basic editor with plugin system.
 */
public class Editor {

    private JFrame frame;
    private JTextArea textArea;
    private JMenu menuPlugin;
    private JMenu menuHelp;
    private FileChecker checker;

    /**
     * Create a new editor.
     *
     * @param directory the directory to search plugins
     */
    public Editor(String directory) {
        this.init();
        this.checker = new FileChecker(directory + "/" + "plugins", new PluginFilter());
        this.checker.addFileListener(new Editor.PluginListener());

    }

    /**
     * Init the components of the editor.
     */
    public void init() {
        this.frame = new JFrame("Editor");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.textArea = new JTextArea(25, 80);
        this.textArea.setFont(this.textArea.getFont().deriveFont(16.0F));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(this.initFileMenu());

        this.menuPlugin = new JMenu("Tools");
        menuBar.add(this.menuPlugin);

        this.menuHelp = new JMenu("Help");
        menuBar.add(this.menuHelp);

        this.frame.setJMenuBar(menuBar);
        this.frame.getContentPane().add(new JScrollPane(this.textArea), "Center");
        this.frame.pack();
    }

    /**
     * Init the menu for open a file.
     *
     * @return the file menu
     */
    private JMenu initFileMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");

        newItem.addActionListener(new Editor.NewListener());
        fileMenu.add(newItem);

        newItem = new JMenuItem("Open");
        newItem.addActionListener(new Editor.OpenFileListener());
        fileMenu.add(newItem);

        fileMenu.addSeparator();

        newItem = new JMenuItem("Exit");
        newItem.addActionListener(new Editor.CloseActionListener());
        fileMenu.add(newItem);

        return fileMenu;
    }

    /**
     * Define the period to check the plugin directory.
     *
     * @param period the new period
     */
    public void setPeriod(int period) {
        this.checker.setPeriod(period);
    }

    /**
     * Start the editor and the timer.
     */
    public void start() {
        this.frame.setVisible(true);
        this.checker.start();
    }

    /**
     * A listener for detect a new file.
     */
    private class NewListener implements ActionListener {
        private NewListener() {

        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Editor.this.textArea.setText("");
        }
    }

    /**
     * A listener for open a new file.
     */
    private class OpenFileListener implements ActionListener {
        private OpenFileListener() {

        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            StringBuffer buffer = new StringBuffer("");
            JFileChooser fileChooser = new JFileChooser(new File("."));

            if (fileChooser.showOpenDialog(Editor.this.frame) == 0) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                    String stringToRead;

                    while ((stringToRead = reader.readLine()) != null) {
                        buffer.append(stringToRead).append("\n");
                    }
                } catch (Exception except) {
                    JOptionPane.showMessageDialog(Editor.this.frame, "Read error in " + fileChooser.getSelectedFile().getName());
                }
                Editor.this.textArea.setText(buffer.toString());
            }
        }
    }

    /**
     * A listener to close the windows.
     */
    private class CloseActionListener implements ActionListener {
        private CloseActionListener() {

        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    /**
     * A menu element for a plugin.
     */
    private class PluginItem extends JMenuItem {
        private Plugin plugin;

        public PluginItem(Plugin plugin) {
            super(plugin.getLabel());
            this.plugin = plugin;
            this.addActionListener(new Editor.PluginItem.PluginItemAction());
        }

        private class PluginItemAction implements ActionListener {
            private PluginItemAction() {
            }

            public void actionPerformed(ActionEvent actionEvent) {
                Editor.this.textArea.setText(PluginItem.this.plugin.transform(Editor.this.textArea.getText()));
            }
        }
    }

    /**
     * A listener for a new plugin file detected.
     */
    private class PluginListener implements FileListener {
        private PluginListener() {
        }

        private Plugin getPluginFromEvent(FileEvent fileEvent) {
            String fileName = fileEvent.getFileName();
            fileName = fileName.substring(0, fileName.length() - ".class".length());

            try {
                Class pluginClass = Class.forName("plugins." + fileName);
                return (Plugin) pluginClass.newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException except) {
                throw new RuntimeException(except);
            }
        }

        public void fileAdded(FileEvent fileEvent) {
            Plugin plugin = this.getPluginFromEvent(fileEvent);
            Editor.this.menuPlugin.add(Editor.this.new PluginItem(plugin));
            JMenuItem item = new JMenuItem(plugin.getLabel());
            item.addActionListener(Editor.this.new HelpItemActionListener(plugin.helpMessage()));
            Editor.this.menuHelp.add(item);
        }

        public void fileRemoved(FileEvent fileEvent) {
            Plugin plugin = this.getPluginFromEvent(fileEvent);

            for (int i = 0; i < Editor.this.menuPlugin.getItemCount(); ++i) {
                if (Editor.this.menuPlugin.getItem(i).getText().equals(plugin.getLabel())) {
                    Editor.this.menuPlugin.remove(i);
                    Editor.this.menuHelp.remove(i);
                    return;
                }
            }

        }
    }

    /**
     * A listener for display the help menu.
     */
    private class HelpItemActionListener implements ActionListener {
        private String msg;

        public HelpItemActionListener(String s) {
            this.msg = s;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(Editor.this.frame, this.msg, "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
