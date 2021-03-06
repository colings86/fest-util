/*
 * Created on Oct 8, 2007
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;

import java.util.LinkedHashSet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link Sets#newLinkedHashSet(Object...)}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class Sets_newLinkedHashSet_Test {
  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_return_Set_containing_all_elements_in_array() {
    String[] expected = { "One", "Two" };
    LinkedHashSet<String> set = Sets.newLinkedHashSet(expected);
    assertArrayEquals(expected, set.toArray());
  }

  @Test
  public void should_throw_error_if_array_is_null() {
    thrown.expect(NullPointerException.class);
    Object[] elements = null;
    assertNull(Sets.newLinkedHashSet(elements));
  }

  @Test
  public void should_return_empty_Set_if_array_is_empty() {
    LinkedHashSet<Object> set = Sets.newLinkedHashSet(new Object[0]);
    assertTrue(set.isEmpty());
  }
}
