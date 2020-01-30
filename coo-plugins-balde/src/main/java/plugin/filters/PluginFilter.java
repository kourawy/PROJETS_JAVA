package plugin.filters;

import plugin.Plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * The filter for the plugins files.
 */
public class PluginFilter implements FilenameFilter {

    /**
     * Create a new plugin filter.
     */
    public PluginFilter() {

    }

    @Override
    public boolean accept(File file, String fileName) {
        if (!fileName.endsWith(".class")) {
            return false;
        } else {

            fileName = fileName.substring(0, fileName.length() - ".class".length());
            Class pluginClass;

            try {
                pluginClass = Class.forName("plugins." + fileName);
                if (pluginClass.isInterface()) {
                    return false;
                } else if (!pluginClass.getPackage().getName().equals("plugins")) {
                    return false;
                } else {
                    Constructor classConstructor = pluginClass.getConstructor();
                    return Plugin.class.isAssignableFrom(pluginClass);
                }
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                return false;
            }
        }
    }
}
