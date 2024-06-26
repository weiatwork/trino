/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.parquet.reader;

import io.trino.parquet.reader.BenchmarkBinaryColumnReader.Encoding;
import io.trino.parquet.reader.BenchmarkBinaryColumnReader.FieldType;
import io.trino.parquet.reader.BenchmarkBinaryColumnReader.PositionLength;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestBinaryColumnBenchmark
{
    @Test
    public void testBinaryColumnBenchmark()
            throws IOException
    {
        for (Encoding encoding : Encoding.values()) {
            for (FieldType type : FieldType.values()) {
                for (PositionLength length : PositionLength.values()) {
                    BenchmarkBinaryColumnReader benchmark = new BenchmarkBinaryColumnReader();
                    benchmark.encoding = encoding;
                    benchmark.type = type;
                    benchmark.positionLength = length;
                    benchmark.setup();
                    benchmark.read();
                }
            }
        }
    }
}
