/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2023, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * https://plantuml.com/patreon (only 1$ per month!)
 * https://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Original Author:  Arnaud Roques
 */
package net.sourceforge.plantuml.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.sourceforge.plantuml.FileUtils;
import net.sourceforge.plantuml.brotli.BrotliInputStream;
import net.sourceforge.plantuml.log.Logme;

public class CompressionBrotli implements Compression {

	public byte[] compress(byte[] in) {
		throw new UnsupportedOperationException();
	}

	public ByteArray decompress(byte[] in) throws NoPlantumlCompressionException {
		try (
				final BrotliInputStream brotli = new BrotliInputStream(new ByteArrayInputStream(in));
				final ByteArrayOutputStream result = new ByteArrayOutputStream();
		) {
			FileUtils.copyToStream(brotli, result);
			return ByteArray.from(result.toByteArray());
		} catch (IOException e) {
			Logme.error(e);
			throw new NoPlantumlCompressionException(e);
		}
	}

}
