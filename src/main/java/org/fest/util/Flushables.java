/*
 * Created on Jan 15, 2008
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2008-2013 the original author or authors.
 */
package org.fest.util;

import java.io.Flushable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Utility methods related to {@link Flushable}.
 * 
 * @author Yvonne Wang
 */
public class Flushables {
  /**
   * Flushes the given {@link Flushable}s, ignoring any thrown exceptions.
   * 
   * @param flushables the {@code Flushable}s to flush.
   */
  public static void flush(@Nonnull Flushable... flushables) {
    for (Flushable f : flushables) {
      flushFlushable(f);
    }
  }

  private static void flushFlushable(@Nullable Flushable f) {
    if (f == null) {
      return;
    }
    try {
      f.flush();
    } catch (Exception e) {
    }
  }

  private Flushables() {}
}
