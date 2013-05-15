/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.oak.spi.security.authorization.restriction;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;
import org.apache.jackrabbit.oak.api.PropertyState;

/**
 * {@code RestrictionImpl}
 */
public class RestrictionImpl extends RestrictionDefinitionImpl implements Restriction {

    private final PropertyState property;

    public RestrictionImpl(@Nonnull PropertyState property, boolean isMandatory) {
        super(property.getName(), property.getType(), isMandatory);
        this.property = property;
    }

    //--------------------------------------------------------< Restriction >---
    @Nonnull
    @Override
    public PropertyState getProperty() {
        return property;
    }

    //-------------------------------------------------------------< Object >---
    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getRequiredType(), isMandatory(), property);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof RestrictionImpl) {
            RestrictionImpl other = (RestrictionImpl) o;
            return super.equals(other) && property.equals(other.property);
        }

        return false;
    }
}
