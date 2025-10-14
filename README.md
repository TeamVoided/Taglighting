![Taglighting Logo](https://cdn.modrinth.com/data/cached_images/af22d7f91df2b36b43f4283ba2327c8ebfb6b824.png)
---
Finally feature X is now a tag instead of being a random hardcoded thing. Yipeee!

# What does the mod do?

The mod changes a lot of hard coded behaviours in the game to be based of tags instead. For example, Nether sprouts can
only be placed on a hard coded list of nether blocks. So if you wanted to plan them on soul sand you would have to write
a mixin. Well this mod just adds a lot of sensible tags like that.
The mod is made with the approach to not change the vanilla behaviours by default. But to allow modification with
datapacks.

# The contents

### Block Tags

- `SUGAR_CANE_HYDRATION` - Blocks that sugarcane can be placed next to and act as hydration [Default: Ice, Frosted ICE]
- `ENDERMAN_PLACEABLE` - Endermen can only place blocks in this tag [Default: "#minecraft:enderman_holdable"]
- `NETHER_PORTAL_FRAME` - What block portal frames can be made out of [Default: Obsidian]
- `PISTON_IMMOVABLE` - Blocks pistons cant
  move [Default: Obsidian, Crying Obsidian, Respawn Anchor, Reinforced Deepslate]
- `UNIQUE_STICKY_BLOCK` - Block that behave like slime / honey blocks when moving with
  piston [Default: Slime Block, "#taglighting:mob_moving_sticky_block"]
- `MOB_MOVING_STICKY_BLOCK` - Blocks that move mobs with them when moved by a piston (aka Honey
  Block) [Default: Honey Block]
- `SNOW_GOLEM_BASE` - Blocks that can be used to make a snow golem base [Default: Snow Block]
- `IRON_GOLEM_BASE` - Blocks that can be used to make an iron golem base [Default: Iron Block]
- `CANNOT_CONNECT_TO` - Blocks that connecting blocks, like fences and walls, won't connect
  to  [Default: "#minecraft:leaves", "#minecraft:shulker_boxes", Barrier, Carved Pumpkin, Jack o' Lantern, Melon, Pumpkin]
- All of these blocks are in the supports category. This means that you can place then block / item on this tag:
    - `SUPPORTS_SUGAR_CANE` - [Default: "#minecraft:dirt", "#minecraft:sand" ]
    - `SUPPORTS_WITHER_ROSE` - [Default: "#minecraft:dirt", Farmland, Netherrack, Soul Sand, Soul Soil]
    - `SUPPORTS_CACTUS` - [Default: "#minecraft:sand" ]
    - `SUPPORTS_NYLIUM_PLANTS` - [Default: "#minecraft:nylium", "#minecraft:dirt", Farmland, Soul Soil]
    - `SUPPORTS_COCOA` - [Default: "#minecraft:jungle_logs" ]
    - `SUPPORTS_END_CRYSTAL` - [Default: Obsidian, Bedrock ]

### Item Tags

- `IRON_GOLEM_REPAIR_MATERIALS` - Items that can be used to repair iron golems [Default: Iron Ingot ]

### Potion Tags

- `MAKES_MUD` - Potions that when used on dirt will turn it in to mud [Default: Water ]

### Fluid Tags

- `SUGAR_CANE_HYDRATION` - Fluids that sugarcane can be placed next to and act as hydration [Default: "#minecraft:water" ]

### Entity Tags

- `UNTARGETABLE` - Entities other aggressive entities cant target [Default: Empty ]
- `WARDEN_UNTARGETABLE` - Entities the Warden won't target [Default: "#taglighting:untargetable", Armor Stand, Warden ]
- `ZOGLIN_UNTARGETABLE` - Entities the Zoglin won't target [Default: "#taglighting:untargetable", Zoglin, Creeper ]
- `JOHNNY_UNTARGETABLE` - Entities a "Johnny" Vindicator won't target [Default: "#taglighting:untargetable" ]

[![Kinetic Partner Banner](https://raw.githubusercontent.com/theendercore/EndAssets/refs/heads/main/kinetic_banner.png)](https://billing.kinetichosting.net/aff.php?aff=853)

[Click on the banner or here to support me and my projects! :)](https://billing.kinetichosting.net/aff.php?aff=853)

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/M4M7DWJCH)