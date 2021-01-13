package tc.oc.pgm.util.material.matcher;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import tc.oc.pgm.util.material.MaterialMatcher;

public class BlockMaterialMatcher implements MaterialMatcher {

  public static final BlockMaterialMatcher INSTANCE = new BlockMaterialMatcher();

  private BlockMaterialMatcher() {}

  private static final ImmutableSet<Material> BLOCKS =
      new ImmutableSet.Builder<Material>()
          .addAll(
              Collections2.filter(
                  Arrays.asList(Material.values()),
                  material -> material != null && material.isBlock()))
          .build();

  @Override
  public boolean matches(Material material) {
    return material.isBlock();
  }

  @Override
  public boolean matches(MaterialData materialData) {
    return materialData.getItemType().isBlock();
  }

  @Override
  public boolean matches(ItemStack stack) {
    return stack.getType().isBlock();
  }

  @Override
  public Collection<Material> getMaterials() {
    return BLOCKS;
  }
}
