package helion.content.blocks;

import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import helion.content.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

import arc.graphics.Color;

public class HelionDefenceBlocks{
    public static Block bolt;
    
    public static void load(){
        bolt = new PowerTurret("bolt") {{
            requirements(Category.turret, with(Items.surgeAlloy, 125, Items.silicon, 200, Items.graphite, 250, Items.oxide, 40));

            shootType = new BasicBulletType(){{
                shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                    colorTo = Pal.surge;
                    sizeTo = 26f;
                    lifetime = 14f;
                    strokeFrom = 4f;
                }});
                smokeEffect = Fx.shootSmokeTitan;
                hitColor = Pal.surge;

                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 4f;
                pierceCap = 2;
                buildingDamageMultiplier = 0.5f;
                fragOnHit = false;
                speed = 5f;
                damage = 180f;
                lifetime = 80f;
                width = height = 16f;
                backColor = Pal.surge;
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
                trailColor = Pal.surge;
                trailLength = 12;
                trailWidth = 2.2f;
                despawnEffect = hitEffect = new ExplosionEffect(){{
                    waveColor = Pal.surge;
                    smokeColor = Color.gray;
                    sparkColor = Pal.sap;
                    waveStroke = 4f;
                    waveRad = 40f;
                }};
                despawnSound = Sounds.dullExplosion;

                //TODO shoot sound
                shootSound = Sounds.cannon;

                fragBullet = intervalBullet = new BasicBulletType(3f, 35){{
                    width = 9f;
                    hitSize = 5f;
                    height = 15f;
                    pierce = true;
                    lifetime = 35f;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Pal.surge;
                    frontColor = Color.white;
                    trailWidth = 2.1f;
                    trailLength = 5;
                    hitEffect = despawnEffect = new WaveEffect(){{
                        colorFrom = colorTo = Pal.surge;
                        sizeTo = 4f;
                        strokeFrom = 4f;
                        lifetime = 10f;
                    }};
                    buildingDamageMultiplier = 0.3f;
                    homingPower = 0.2f;
                }};

                bulletInterval = 3f;
                intervalRandomSpread = 20f;
                intervalBullets = 2;
                intervalAngle = 180f;
                intervalSpread = 300f;

                fragBullets = 20;
                fragVelocityMin = 0.5f;
                fragVelocityMax = 1.5f;
                fragLifeMin = 0.5f;
            }};

            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-blade"){{
                    progress = PartProgress.recoil;
                    heatColor = Color.valueOf("ff6214");
                    mirror = true;
                    under = true;
                    moveX = 2f;
                    moveY = -1f;
                    moveRot = -7f;
                }},
                new RegionPart("-blade-glow"){{
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.valueOf("ff6214");
                    drawRegion = false;
                    mirror = true;
                    under = true;
                    moveX = 2f;
                    moveY = -1f;
                    moveRot = -7f;
                }});
            }};

            consumePower(5f);
            heatRequirement = 10f;
            maxHeatEfficiency = 2f;

            inaccuracy = 1f;
            shake = 2f;
            shootY = 3;
            outlineColor = Pal.darkOutline;
            size = 4;
            envEnabled |= Env.space;
            reload = 100f;
            cooldownTime = reload;
            recoil = 3f;
            range = 350;
            shootCone = 20f;
            scaledHealth = 220;
            rotateSpeed = 1.5f;
            researchCostMultiplier = 0.04f;

            limitRange(9f);
        };
        };
    };
}