/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.CompactArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;
import org.apache.kafka.common.utils.ImplicitLinkedHashCollection;
import org.apache.kafka.common.utils.ImplicitLinkedHashMultiCollection;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class UpdateFeaturesRequestData implements ApiMessage {
    int timeoutMs;
    FeatureUpdateKeyCollection featureUpdates;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("timeout_ms", Type.INT32, "How long to wait in milliseconds before timing out the request."),
            new Field("feature_updates", new CompactArrayOf(FeatureUpdateKey.SCHEMA_0), "The list of updates to finalized features."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public UpdateFeaturesRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public UpdateFeaturesRequestData() {
        this.timeoutMs = 60000;
        this.featureUpdates = new FeatureUpdateKeyCollection(0);
    }
    
    @Override
    public short apiKey() {
        return 57;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        this.timeoutMs = _readable.readInt();
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field featureUpdates was serialized as null");
            } else {
                FeatureUpdateKeyCollection newCollection = new FeatureUpdateKeyCollection(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new FeatureUpdateKey(_readable, _version));
                }
                this.featureUpdates = newCollection;
            }
        }
        this._unknownTaggedFields = null;
        int _numTaggedFields = _readable.readUnsignedVarint();
        for (int _i = 0; _i < _numTaggedFields; _i++) {
            int _tag = _readable.readUnsignedVarint();
            int _size = _readable.readUnsignedVarint();
            switch (_tag) {
                default:
                    this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                    break;
            }
        }
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeInt(timeoutMs);
        _writable.writeUnsignedVarint(featureUpdates.size() + 1);
        for (FeatureUpdateKey featureUpdatesElement : featureUpdates) {
            featureUpdatesElement.write(_writable, _cache, _version);
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _size.addBytes(4);
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(featureUpdates.size() + 1));
            for (FeatureUpdateKey featureUpdatesElement : featureUpdates) {
                featureUpdatesElement.addSize(_size, _cache, _version);
            }
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UpdateFeaturesRequestData)) return false;
        UpdateFeaturesRequestData other = (UpdateFeaturesRequestData) obj;
        if (timeoutMs != other.timeoutMs) return false;
        if (this.featureUpdates == null) {
            if (other.featureUpdates != null) return false;
        } else {
            if (!this.featureUpdates.equals(other.featureUpdates)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + timeoutMs;
        hashCode = 31 * hashCode + (featureUpdates == null ? 0 : featureUpdates.hashCode());
        return hashCode;
    }
    
    @Override
    public UpdateFeaturesRequestData duplicate() {
        UpdateFeaturesRequestData _duplicate = new UpdateFeaturesRequestData();
        _duplicate.timeoutMs = timeoutMs;
        FeatureUpdateKeyCollection newFeatureUpdates = new FeatureUpdateKeyCollection(featureUpdates.size());
        for (FeatureUpdateKey _element : featureUpdates) {
            newFeatureUpdates.add(_element.duplicate());
        }
        _duplicate.featureUpdates = newFeatureUpdates;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "UpdateFeaturesRequestData("
            + "timeoutMs=" + timeoutMs
            + ", featureUpdates=" + MessageUtil.deepToString(featureUpdates.iterator())
            + ")";
    }
    
    public int timeoutMs() {
        return this.timeoutMs;
    }
    
    public FeatureUpdateKeyCollection featureUpdates() {
        return this.featureUpdates;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public UpdateFeaturesRequestData setTimeoutMs(int v) {
        this.timeoutMs = v;
        return this;
    }
    
    public UpdateFeaturesRequestData setFeatureUpdates(FeatureUpdateKeyCollection v) {
        this.featureUpdates = v;
        return this;
    }
    
    public static class FeatureUpdateKey implements Message, ImplicitLinkedHashMultiCollection.Element {
        String feature;
        short maxVersionLevel;
        boolean allowDowngrade;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("feature", Type.COMPACT_STRING, "The name of the finalized feature to be updated."),
                new Field("max_version_level", Type.INT16, "The new maximum version level for the finalized feature. A value >= 1 is valid. A value < 1, is special, and can be used to request the deletion of the finalized feature."),
                new Field("allow_downgrade", Type.BOOLEAN, "When set to true, the finalized feature version level is allowed to be downgraded/deleted. The downgrade request will fail if the new maximum version level is a value that's not lower than the existing maximum finalized version level."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public FeatureUpdateKey(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public FeatureUpdateKey() {
            this.feature = "";
            this.maxVersionLevel = (short) 0;
            this.allowDowngrade = false;
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 0;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of FeatureUpdateKey");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field feature was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field feature had invalid length " + length);
                } else {
                    this.feature = _readable.readString(length);
                }
            }
            this.maxVersionLevel = _readable.readShort();
            this.allowDowngrade = _readable.readByte() != 0;
            this._unknownTaggedFields = null;
            int _numTaggedFields = _readable.readUnsignedVarint();
            for (int _i = 0; _i < _numTaggedFields; _i++) {
                int _tag = _readable.readUnsignedVarint();
                int _size = _readable.readUnsignedVarint();
                switch (_tag) {
                    default:
                        this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                        break;
                }
            }
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(feature);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeShort(maxVersionLevel);
            _writable.writeByte(allowDowngrade ? (byte) 1 : (byte) 0);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of FeatureUpdateKey");
            }
            {
                byte[] _stringBytes = feature.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'feature' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(feature, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(2);
            _size.addBytes(1);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof FeatureUpdateKey)) return false;
            FeatureUpdateKey other = (FeatureUpdateKey) obj;
            if (this.feature == null) {
                if (other.feature != null) return false;
            } else {
                if (!this.feature.equals(other.feature)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FeatureUpdateKey)) return false;
            FeatureUpdateKey other = (FeatureUpdateKey) obj;
            if (this.feature == null) {
                if (other.feature != null) return false;
            } else {
                if (!this.feature.equals(other.feature)) return false;
            }
            if (maxVersionLevel != other.maxVersionLevel) return false;
            if (allowDowngrade != other.allowDowngrade) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (feature == null ? 0 : feature.hashCode());
            return hashCode;
        }
        
        @Override
        public FeatureUpdateKey duplicate() {
            FeatureUpdateKey _duplicate = new FeatureUpdateKey();
            _duplicate.feature = feature;
            _duplicate.maxVersionLevel = maxVersionLevel;
            _duplicate.allowDowngrade = allowDowngrade;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "FeatureUpdateKey("
                + "feature=" + ((feature == null) ? "null" : "'" + feature.toString() + "'")
                + ", maxVersionLevel=" + maxVersionLevel
                + ", allowDowngrade=" + (allowDowngrade ? "true" : "false")
                + ")";
        }
        
        public String feature() {
            return this.feature;
        }
        
        public short maxVersionLevel() {
            return this.maxVersionLevel;
        }
        
        public boolean allowDowngrade() {
            return this.allowDowngrade;
        }
        
        @Override
        public int next() {
            return this.next;
        }
        
        @Override
        public int prev() {
            return this.prev;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public FeatureUpdateKey setFeature(String v) {
            this.feature = v;
            return this;
        }
        
        public FeatureUpdateKey setMaxVersionLevel(short v) {
            this.maxVersionLevel = v;
            return this;
        }
        
        public FeatureUpdateKey setAllowDowngrade(boolean v) {
            this.allowDowngrade = v;
            return this;
        }
        
        @Override
        public void setNext(int v) {
            this.next = v;
        }
        
        @Override
        public void setPrev(int v) {
            this.prev = v;
        }
    }
    
    public static class FeatureUpdateKeyCollection extends ImplicitLinkedHashMultiCollection<FeatureUpdateKey> {
        public FeatureUpdateKeyCollection() {
            super();
        }
        
        public FeatureUpdateKeyCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public FeatureUpdateKeyCollection(Iterator<FeatureUpdateKey> iterator) {
            super(iterator);
        }
        
        public FeatureUpdateKey find(String feature) {
            FeatureUpdateKey _key = new FeatureUpdateKey();
            _key.setFeature(feature);
            return find(_key);
        }
        
        public List<FeatureUpdateKey> findAll(String feature) {
            FeatureUpdateKey _key = new FeatureUpdateKey();
            _key.setFeature(feature);
            return findAll(_key);
        }
        
        public FeatureUpdateKeyCollection duplicate() {
            FeatureUpdateKeyCollection _duplicate = new FeatureUpdateKeyCollection(size());
            for (FeatureUpdateKey _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
