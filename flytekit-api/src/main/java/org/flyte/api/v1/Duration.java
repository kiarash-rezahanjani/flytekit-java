/*
 * Copyright 2020 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.flyte.api.v1;

import static org.flyte.api.v1.Preconditions.checkNanosInRange;

import com.google.auto.value.AutoValue;

/**
 * A Duration represents a signed, fixed-length span of time represented as a count of seconds and
 * fractions of seconds at nanosecond resolution. It is independent of any calendar and concepts
 * like "day" or "month".
 */
@AutoValue
public abstract class Duration {

  public abstract long seconds();

  public abstract int nanos();

  public static Builder builder() {
    return new AutoValue_Duration.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder seconds(long seconds);

    public abstract Builder nanos(int nanos);

    // required for property validation
    abstract int nanos();

    abstract Duration autoBuild();

    public Duration build() {
      Duration duration = autoBuild();
      checkNanosInRange(duration.nanos());
      return duration;
    }
  }
}