package tc.oc.pgm.chat;

import java.util.Locale;
import javax.annotation.Nullable;
import net.kyori.text.TextComponent;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.format.TextColor;
import org.bukkit.command.CommandSender;
import tc.oc.pgm.api.chat.Audience;
import tc.oc.pgm.api.chat.Sound;
import tc.oc.util.bukkit.component.Component;
import tc.oc.util.bukkit.component.ComponentRenderers;
import tc.oc.util.bukkit.translations2.ComponentProvider;

public class CommandSenderAudience implements Audience {

  private static final ComponentProvider TRANSLATION_PROVIDER =
      new ComponentProvider(null, Locale.US);

  protected final CommandSender sender;

  public CommandSenderAudience(CommandSender sender) {
    this.sender = sender;
  }

  protected CommandSender getCommandSender() {
    return sender;
  }

  protected net.kyori.text.Component render(
      net.kyori.text.Component message, CommandSender sender) {
    return TRANSLATION_PROVIDER.getComponent(message, sender.getLocale());
  }

  @Override
  public void sendMessage(net.kyori.text.Component message) {
    TextAdapter.sendComponent(sender, render(message, sender));
  }

  @Override
  public void sendWarning(net.kyori.text.Component message) {
    sendMessage(
        TextComponent.of(" \u26a0 ", TextColor.YELLOW).append(message).color(TextColor.RED));
    playSound(new Sound("note.bass", 1f, 0.75f));
  }

  @Override
  public void showHotbar(net.kyori.text.Component hotbar) {}

  @Override
  public void sendMessage(String message) {
    getCommandSender().sendMessage(message);
  }

  @Override
  public void sendMessage(Component message) {
    ComponentRenderers.send(getCommandSender(), message);
  }

  @Override
  public void sendHotbarMessage(Component message) {}

  @Override
  public void showTitle(
      @Nullable Component title,
      @Nullable Component subtitle,
      int inTicks,
      int stayTicks,
      int outTicks) {}

  @Override
  public void playSound(Sound sound) {}
}
