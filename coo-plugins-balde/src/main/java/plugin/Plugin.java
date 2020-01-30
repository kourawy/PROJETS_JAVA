package plugin;

/**
 * Define the structure of the plugins.
 */
public interface Plugin {
    String PLUGIN_PACKAGE = "plugin";

    /**
     * The method who say how to transform a string.
     *
     * @param s the string to transform
     * @return the string after the transformation
     */
    String transform(String s);

    /**
     * Get the label of the plugin.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Get the help message of the plugin.
     *
     * @return the help message
     */
    String helpMessage();
}
