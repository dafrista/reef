/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.reef.vortex.examples.matmul;

import org.apache.reef.io.serialization.Codec;
import org.apache.reef.vortex.api.VortexFunction;

/**
 * Computes multiplication of two matrices.
 */
final class MatMulFunction implements VortexFunction<MatMulInput, MatMulOutput> {
  private static final Codec<MatMulInput> INPUT_CODEC = new MatMulInputCodec();
  private static final Codec<MatMulOutput> OUTPUT_CODEC = new MatMulOutputCodec();

  /**
   * Computes multiplication of two matrices.
   * @param input Input which contains two matrices to multiply,
   *              and index of the sub-matrix in the entire result.
   * @return Output which contains the sub-matrix and index of it in the entire result.
   * @throws Exception If the two matrices cannot be multiplied.
   */
  @Override
  public MatMulOutput call(final MatMulInput input) throws Exception {
    final int index = input.getIndex();
    final Matrix<Double> leftMatrix = input.getLeftMatrix();
    final Matrix<Double> rightMatrix = input.getRightMatrix();
    final Matrix<Double> result = leftMatrix.multiply(rightMatrix);
    return new MatMulOutput(index, result);
  }

  @Override
  public Codec<MatMulInput> getInputCodec() {
    return INPUT_CODEC;
  }

  @Override
  public Codec<MatMulOutput> getOutputCodec() {
    return OUTPUT_CODEC;
  }
}
