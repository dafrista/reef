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

package org.apache.reef.driver.parameters;

import org.apache.reef.tang.annotations.NamedParameter;
import org.apache.reef.tang.annotations.Name;

/**
 * @deprecated in 0.14. Use org.apache.reef.runtime.yarn.driver.parameters.JobSubmissionDirectory.
 */
// TODO[JIRA REEF-904]: Act on deprecated JobSubmissionDirectory and JOB_SUBMISSION_DIRECTORY
@NamedParameter(doc = "The job submission directory.")
public final class JobSubmissionDirectory implements Name<String> {
}
