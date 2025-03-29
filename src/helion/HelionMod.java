package helion;

import mindustry.mod.*;
import helion.gen.*;
import helion.content.*;

public class HelionMod extends Mod{
    @Override

    public void loadContent(){
        EntityRegistry.register();
        HelionBlocks.load();
    }
}
