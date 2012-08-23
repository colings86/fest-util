/*
 * Created on Apr 29, 2007
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
 * Copyright @2007-2012 the original author or authors.
 */
package org.fest.util;

import static java.util.Collections.*;
import static org.fest.util.ToString.toStringOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility methods related to {@code Collection}s.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public final class Collections {
  /**
   * Returns any duplicate elements from the given {@code Collection}.
   * 
   * @param <T> the generic type of the given {@code Collection}.
   * @param c the given {@code Collection} that might have duplicate elements.
   * @return a {@code Collection} containing the duplicate elements of the given one. If no duplicates are found, an
   *         empty {@code Collection} is returned.
   */
  public static <T> Collection<T> duplicatesFrom(Collection<T> c) {
    Set<T> duplicates = new LinkedHashSet<T>();
    if (isEmpty(c)) {
      return duplicates;
    }
    Set<T> noDuplicates = new HashSet<T>();
    for (T e : c) {
      if (noDuplicates.contains(e)) {
        duplicates.add(e);
        continue;
      }
      noDuplicates.add(e);
    }
    return duplicates;
  }

  /**
   * Returns {@code true} if the given {@link Iterable} is {@code null} or empty.
   * 
   * @param iterable the {@link Iterable} to check.
   * @return {@code true} if the given {@link Iterable} is {@code null} or empty, otherwise {@code false}.
   */
  public static boolean isEmpty(Iterable<?> iterable) {
    return iterable == null || !iterable.iterator().hasNext();
  }

  /**
   * Returns the size of the given {@link Iterable}.
   * 
   * @param iterable the {@link Iterable} to get size.
   * @return the size of the given {@link Iterable}..
   * @throws IllegalArgumentException if given {@link Iterable} is null.
   */
  public static int sizeOf(Iterable<?> iterable) {
    if (iterable == null) {
      throw new IllegalArgumentException("iterable parameter must not be null");
    }
    int size = 0;
    for (@SuppressWarnings("unused")
    Object object : iterable) {
      size++;
    }
    return size;
  }

  /**
   * Returns the {@code String} representation of the given {@code Collection}, or {@code null} if the given
   * {@code Collection} is {@code null}.
   * 
   * @param c the {@code Collection} to format.
   * @return the {@code String} representation of the given {@code Collection}.
   */
  public static String format(Collection<?> c) {
    if (c == null) {
      return null;
    }
    Iterator<?> i = c.iterator();
    if (!i.hasNext()) {
      return "[]";
    }
    StringBuilder b = new StringBuilder();
    b.append('[');
    for (;;) {
      Object e = i.next();
      b.append(e == c ? "(this Collection)" : toStringOf(e));
      if (!i.hasNext()) {
        return b.append(']').toString();
      }
      b.append(", ");
    }
  }

  /**
   * Returns a new unmodifiable {@code Collection} containing the non-null elements of the given {@code Collection}.
   * This method returns an empty unmodifiable {@code Collection} if the given {@code Collection} has only {@code null}
   * elements or if it is empty. This method returns {@code null} if the given {@code Collection} is {@code null}.
   * 
   * @param <T> the type of elements of the {@code Collection}.
   * @param c the {@code Collection} we want to extract non-{@code null} elements from.
   * @return a new unmodifiable containing the non-null elements of the given {@code Collection}, or {@code null} if the
   *         given {@code Collection} is {@code null}.
   * @since 1.1.3
   */
  public static <T> Iterable<T> nonNullElements(Iterable<T> c) {
    if (c == null) {
      return null;
    }
    Collection<T> nonNullElements = new ArrayList<T>();
    for (T o : c) {
      if (o != null) {
        nonNullElements.add(o);
      }
    }
    return unmodifiableCollection(nonNullElements);
  }

  /**
   * Returns a new unmodifiable list containing the non-null elements of the given list. This method returns an empty
   * unmodifiable list if the given list has only {@code null} elements or if it is empty. This method returns
   * {@code null} if the given list is {@code null}.
   * 
   * @param <T> the type of elements of the list.
   * @param l the list we want to extract non null elements from.
   * @return a new unmodifiable list containing the non-null elements of the given list, or {@code null} if the given
   *         list is {@code null}.
   * @since 1.1.3
   */
  public static <T> List<T> nonNullElements(List<T> l) {
    Collection<T> nonNullElements = (Collection<T>) nonNullElements((Collection<T>) l);
    if (nonNullElements == null) {
      return null;
    }
    return unmodifiableList(new ArrayList<T>(nonNullElements));
  }

  /**
   * Returns {@code true} if the given {@link Iterable} has only {@code null} elements, {@code false} otherwise. If
   * given {@link Iterable} is empty, this method returns {@code true}.
   * 
   * @param iterable the given iterable. <b>It must not be null</b>.
   * @return {@code true} if the given iterable has only {@code null} elements or is empty, {@code false} otherwise.
   * @throws NullPointerException if the given iterable is {@code null}.
   * @since 1.1.3
   */
  public static boolean hasOnlyNullElements(Iterable<?> iterable) {
    if (iterable == null) {
      throw new NullPointerException("The iterable to check should not be null");
    }
    if (isEmpty(iterable)) {
      return false;
    }
    for (Object element : iterable) {
      if (element != null) {
        return false;
      }
    }
    return true;
  }

  private Collections() {
  }
}
