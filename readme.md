# PossessedMod

**PossessedMod** is a small Forge mod designed to be used with the modpack **FOMO - FEAR of missing out**.

When a specific advancement is granted, this mod moves a file named `thebrokenscript-1.9.3-forge-1.20.1.jar` from a folder named `mods_disabled` into the active `mods` folder, displays a disturbing message, and closes the game.

## ⚠️ Important Notes

- This mod does **not** include or distribute `thebrokenscript-1.9.3-forge-1.20.1.jar`.
- You must manually place the file in a folder named `mods_disabled` in your Minecraft instance directory.
- The file **must** be named exactly: thebrokenscript-1.9.3-forge-1.20.1.jar

## 📥 Where to Get the File

You can download `thebrokenscript-1.9.3-forge-1.20.1.jar` from:
- [Modrinth](https://cdn.modrinth.com/data/TocuaDpt/versions/jhfudBAo/thebrokenscript-1.9.3-forge-1.20.1.jar)
- [The Broken Script Discord](https://discord.gg/nullnullnullnull)

## 🧠 How It Works

- The mod watches for the advancement `fomo:level_5/tbs_start`.
- Once granted, the mod:
1. Copies the `.jar` file from `mods_disabled` to `mods`
2. Displays a creepy message in chat and the log
3. Closes the game after a brief pause

## ❗ Requirements

- Minecraft Forge 1.20.1
- `thebrokenscript-1.9.3-forge-1.20.1.jar` placed in the correct folder and named correctly

## 🧪 Disclaimer

This mod moves a file and shuts the game down by design. It is part of a scripted horror experience and is **not** intended for general gameplay.

---

