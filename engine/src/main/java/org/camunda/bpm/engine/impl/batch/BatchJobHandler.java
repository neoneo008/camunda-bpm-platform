/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.engine.impl.batch;

import org.camunda.bpm.engine.impl.jobexecutor.JobDeclaration;
import org.camunda.bpm.engine.impl.jobexecutor.JobHandler;
import org.camunda.bpm.engine.impl.persistence.entity.MessageEntity;

/**
 * A batch job handler manages batch jobs based
 * on the configuration {@link T}.
 */
public interface BatchJobHandler<T> extends JobHandler {

  /**
   * Converts the configuration of the batch to a byte array.
   *
   * @param configuration the configuration object
   * @return the serialized configuration
   */
  byte[] writeConfiguration(T configuration);

  /**
   * Read the serialized configuration of the batch.
   *
   * @param serializedConfiguration the serialized configuration
   * @return the deserialized configuration object
   */
  T readConfiguration(byte[] serializedConfiguration);

  /**
   * Get the job declaration for batch jobs.
   *
   * @return the batch job declaration
   */
  JobDeclaration<?, MessageEntity> getJobDeclaration();

  /**
   * Creates batch jobs for a batch.
   *
   * @param batch the batch to create jobs for
   * @return true of no more jobs have to be created for this batch, false otherwise
   */
  boolean createJobs(BatchEntity batch);

  /**
   * Delete all jobs for a batch.
   *
   * @param batch the batch to delete jobs for
   */
  void deleteJobs(BatchEntity batch);

}