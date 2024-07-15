package at.alex.pingintablist.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {

    @Expose
    public int fontSize = 12;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    private static ModConfig INSTANCE;
    private static final File CONFIG_FILE = new File("config", "ping_in_tablist.json");

    public static ModConfig getInstance() {
        if (INSTANCE == null) {
            load();
        }
        return INSTANCE;
    }

    public static void load() {
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            INSTANCE = GSON.fromJson(reader, ModConfig.class);
        } catch (IOException e) {
            INSTANCE = new ModConfig();
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}