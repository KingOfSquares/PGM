package tc.oc.pgm.stats;

import java.util.UUID;
import org.bukkit.Skin;

class OfflinePlayerInfoBundle {

  private final UUID uuid;
  private final Skin skin;
  private final String name;

  public OfflinePlayerInfoBundle(UUID uuid, Skin skin, String name) {
    this.uuid = uuid;
    this.skin = skin;
    this.name = name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public Skin getSkin() {
    return skin;
  }

  public String getName() {
    return name;
  }
}
