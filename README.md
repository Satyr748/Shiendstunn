# Shiendstunn

Fabric-Mod für Minecraft **1.21.1**. Der Befehl `/fgt` wechselt zwischen Überleben und Kreativ, ohne dass der Spieler OP sein muss.

## Verhalten

- Survival -> Creative
- Creative -> Survival
- Adventure oder Spectator -> Survival
- Nur Spieler können den Befehl ausführen; Konsole und Command-Blöcke bekommen eine Fehlermeldung.

**Achtung:** Jeder Spieler, der den Befehl verwenden kann, darf sich damit Kreativ-Rechte geben. Nutze die Mod nur auf einem Server, auf dem das ausdrücklich gewollt ist.

## Voraussetzungen

- Java 21 JDK
- Gradle (oder eine Gradle-Wrapper-Datei, falls du eine ergänzt)
- Minecraft 1.21.1
- Fabric Loader und Fabric API für 1.21.1

## Bauen

Im Projektordner ausführen:

```bash
gradle build
```

Die fertige JAR liegt danach unter:

```text
build/libs/shiendstunn-1.0.0.jar
```

## Installieren

1. Installiere Fabric Loader für Minecraft 1.21.1 auf dem Server.
2. Lege die passende Fabric API-JAR in den Serverordner `mods`.
3. Kopiere `shiendstunn-1.0.0.jar` ebenfalls in den Serverordner `mods`.
4. Starte den Server neu.
5. Im Spiel `/fgt` eingeben.

Für einen dedizierten Server muss die Mod nicht auf den Clients installiert werden, da sie serverseitig arbeitet.

## Versionshinweis

Dieses Projekt ist konkret für **Minecraft 1.21.1** konfiguriert. Bei einer anderen 1.21.x-Version müssen Minecraft-Version, Yarn-Mappings und Fabric API-Version zusammenpassen.
