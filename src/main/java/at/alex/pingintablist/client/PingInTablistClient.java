package at.alex.pingintablist.client;

import at.alex.pingintablist.client.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingInTablistClient implements ClientModInitializer {
    public static final String MODID = "pingintablist";
    public static Logger logger = LoggerFactory.getLogger(MODID);
    @Override
    public void onInitializeClient() {
        ModConfig.load();
        logger.info("Loaded config");
    }
}
