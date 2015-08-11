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
package org.apache.reef.driver.restart;

import org.apache.reef.annotations.Unstable;
import org.apache.reef.annotations.audience.DriverSide;
import org.apache.reef.annotations.audience.Private;
import org.apache.reef.annotations.audience.RuntimeAuthor;

import java.util.Set;

/**
 * Classes implementing this interface are in charge of recording evaluator
 * changes as they are allocated as well as recovering Evaluators and
 * discovering which evaluators are lost on the event of a driver restart.
 */
@DriverSide
@Private
@RuntimeAuthor
@Unstable
public interface DriverRuntimeRestartManager {
  /**
   * Determines whether or not the driver has been restarted.
   */
  boolean isRestart();

  /**
   * Records the evaluators when it is allocated.
   * @param id The evaluator ID of the allocated evaluator.
   */
  void recordAllocatedEvaluator(final String id);

  /**
   * Records a removed evaluator into the evaluator log.
   * @param id The evaluator ID of the removed evaluator.
   */
  void recordRemovedEvaluator(final String id);

  /**
   * Gets the sets of alive and failed evaluators based on the runtime implementation.
   * @return EvaluatorRestartInfo, which encapsulates the alive and failed set of evaluator IDs.
   */
  EvaluatorRestartInfo getAliveAndFailedEvaluators();

  /**
   * Informs the necessary components about failed evaluators. The implementation is runtime dependent.
   * @param failedEvaluatorIds The set of evaluator IDs of evaluators that failed during restart.
   */
  void informAboutEvaluatorFailures(final Set<String> failedEvaluatorIds);
}