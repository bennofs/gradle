/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.nio.charset.Charset

plugins {
    id("gradlebuild.available-java-installations")
}

tasks.register("verifyIsProductionBuildEnvironment") {
    val buildJvms = project.buildJvms
    doLast {
        buildJvms.validateForProductionEnvironment()
        val systemCharset = Charset.defaultCharset().name()
        assert(systemCharset == "UTF-8") {
            "Platform encoding must be UTF-8. Is currently $systemCharset. Set -Dfile.encoding=UTF-8"
        }
    }
}
