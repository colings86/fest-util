/*
 * Created on May 13, 2007
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
 * Copyright @2007-2013 the original author or authors.
 */
package org.fest.util;

import static org.fest.util.Arrays.nonNullElementsIn;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link Arrays#nonNullElementsIn(Object[])}.
 * 
 * @author Joel Costigliola
 * @author Alex Ruiz
 */
public class Arrays_nonNullElementsIn_Test {
  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_throw_error_if_given_array_is_null() {
    thrown.expect(NullPointerException.class);
    Arrays.nonNullElementsIn(null);
  }

  @Test
  public void should_return_an_empty_Collection_if_given_array_has_only_null_elements() {
    String[] array = new String[] { null };
    assertTrue(Arrays.nonNullElementsIn(array).isEmpty());
  }

  @Test
  public void should_return_an_empty_Collection_if_given_array_is_empty() {
    String[] array = new String[0];
    assertTrue(Arrays.nonNullElementsIn(array).isEmpty());
  }

  @Test
  public void should_return_a_Collection_without_null_elements() {
    String[] array = { "Frodo", null, "Sam", null };
    List<String> nonNull = nonNullElementsIn(array);
    assertArrayEquals(new String[] { "Frodo", "Sam" }, nonNull.toArray());
  }
}
