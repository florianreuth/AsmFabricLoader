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

import java.util.ArrayList;
import java.util.List;

public class AsmUtil {

    /**
     * @param input A class path
     * @return The class path converted to descriptor format (Replaced all '.' with '/')
     */
    public static String normalizeDescriptor(final String input) {
        return input.replace(".", "/");
    }

    /**
     * @param input A class path
     * @return The class path converted to class name format (Replaced all '/' with '.')
     */
    public static String normalizeClassName(final String input) {
        return input.replace("/", ".");
    }

    /**
     * @param owner A class
     * @return All superclasses of the given class as a list of strings (formatted by {@link #normalizeDescriptor(String)}
     */
    public static List<String> getClassStruct(Class<?> owner) {
        final List<String> classNames = new ArrayList<>();

        classNames.add(normalizeDescriptor(owner.getName()));
        while (!owner.getName().equals("java.lang.Object")) {
            owner = owner.getSuperclass();
            classNames.add(normalizeDescriptor(owner.getName()));
        }

        return classNames;
    }

}
