/*
 * This file is part of AsmFabricLoader - https://github.com/florianreuth/AsmFabricLoader
 * Copyright (C) 2023-2026 Florian Reuth <git@florianreuth.de>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.florianreuth.asmfabricloader.api;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

public final class GameVersion {

    public static final Version MC_26_1;
    private static final Version GAME_VERSION;

    static {
        try {
            MC_26_1 = Version.parse("26.1");
            GAME_VERSION = Version.parse(FabricLoader.getInstance().getRawGameVersion());
        } catch (VersionParsingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean obfuscatedEnvironment() {
        return GAME_VERSION.compareTo(MC_26_1) < 0;
    }

}
