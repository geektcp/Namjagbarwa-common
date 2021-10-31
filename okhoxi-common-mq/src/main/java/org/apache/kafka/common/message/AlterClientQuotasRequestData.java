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
import java.util.List;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.ArrayOf;
import org.apache.kafka.common.protocol.types.CompactArrayOf;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class AlterClientQuotasRequestData implements ApiMessage {
    List<EntryData> entries;
    boolean validateOnly;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("entries", new ArrayOf(EntryData.SCHEMA_0), "The quota configuration entries to alter."),
            new Field("validate_only", Type.BOOLEAN, "Whether the alteration should be validated, but not performed.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("entries", new CompactArrayOf(EntryData.SCHEMA_1), "The quota configuration entries to alter."),
            new Field("validate_only", Type.BOOLEAN, "Whether the alteration should be validated, but not performed."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 1;
    
    public AlterClientQuotasRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public AlterClientQuotasRequestData() {
        this.entries = new ArrayList<EntryData>(0);
        this.validateOnly = false;
    }
    
    @Override
    public short apiKey() {
        return 49;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 1;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            if (_version >= 1) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field entries was serialized as null");
                } else {
                    ArrayList<EntryData> newCollection = new ArrayList<EntryData>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new EntryData(_readable, _version));
                    }
                    this.entries = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field entries was serialized as null");
                } else {
                    ArrayList<EntryData> newCollection = new ArrayList<EntryData>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new EntryData(_readable, _version));
                    }
                    this.entries = newCollection;
                }
            }
        }
        this.validateOnly = _readable.readByte() != 0;
        this._unknownTaggedFields = null;
        if (_version >= 1) {
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
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        if (_version >= 1) {
            _writable.writeUnsignedVarint(entries.size() + 1);
            for (EntryData entriesElement : entries) {
                entriesElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(entries.size());
            for (EntryData entriesElement : entries) {
                entriesElement.write(_writable, _cache, _version);
            }
        }
        _writable.writeByte(validateOnly ? (byte) 1 : (byte) 0);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 1) {
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        {
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(entries.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (EntryData entriesElement : entries) {
                entriesElement.addSize(_size, _cache, _version);
            }
        }
        _size.addBytes(1);
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        if (_version >= 1) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AlterClientQuotasRequestData)) return false;
        AlterClientQuotasRequestData other = (AlterClientQuotasRequestData) obj;
        if (this.entries == null) {
            if (other.entries != null) return false;
        } else {
            if (!this.entries.equals(other.entries)) return false;
        }
        if (validateOnly != other.validateOnly) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (entries == null ? 0 : entries.hashCode());
        hashCode = 31 * hashCode + (validateOnly ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public AlterClientQuotasRequestData duplicate() {
        AlterClientQuotasRequestData _duplicate = new AlterClientQuotasRequestData();
        ArrayList<EntryData> newEntries = new ArrayList<EntryData>(entries.size());
        for (EntryData _element : entries) {
            newEntries.add(_element.duplicate());
        }
        _duplicate.entries = newEntries;
        _duplicate.validateOnly = validateOnly;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "AlterClientQuotasRequestData("
            + "entries=" + MessageUtil.deepToString(entries.iterator())
            + ", validateOnly=" + (validateOnly ? "true" : "false")
            + ")";
    }
    
    public List<EntryData> entries() {
        return this.entries;
    }
    
    public boolean validateOnly() {
        return this.validateOnly;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public AlterClientQuotasRequestData setEntries(List<EntryData> v) {
        this.entries = v;
        return this;
    }
    
    public AlterClientQuotasRequestData setValidateOnly(boolean v) {
        this.validateOnly = v;
        return this;
    }
    
    public static class EntryData implements Message {
        List<EntityData> entity;
        List<OpData> ops;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("entity", new ArrayOf(EntityData.SCHEMA_0), "The quota entity to alter."),
                new Field("ops", new ArrayOf(OpData.SCHEMA_0), "An individual quota configuration entry to alter.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("entity", new CompactArrayOf(EntityData.SCHEMA_1), "The quota entity to alter."),
                new Field("ops", new CompactArrayOf(OpData.SCHEMA_1), "An individual quota configuration entry to alter."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 1;
        
        public EntryData(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public EntryData() {
            this.entity = new ArrayList<EntityData>(0);
            this.ops = new ArrayList<OpData>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of EntryData");
            }
            {
                if (_version >= 1) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field entity was serialized as null");
                    } else {
                        ArrayList<EntityData> newCollection = new ArrayList<EntityData>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new EntityData(_readable, _version));
                        }
                        this.entity = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field entity was serialized as null");
                    } else {
                        ArrayList<EntityData> newCollection = new ArrayList<EntityData>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new EntityData(_readable, _version));
                        }
                        this.entity = newCollection;
                    }
                }
            }
            {
                if (_version >= 1) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field ops was serialized as null");
                    } else {
                        ArrayList<OpData> newCollection = new ArrayList<OpData>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new OpData(_readable, _version));
                        }
                        this.ops = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field ops was serialized as null");
                    } else {
                        ArrayList<OpData> newCollection = new ArrayList<OpData>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new OpData(_readable, _version));
                        }
                        this.ops = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 1) {
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
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version >= 1) {
                _writable.writeUnsignedVarint(entity.size() + 1);
                for (EntityData entityElement : entity) {
                    entityElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(entity.size());
                for (EntityData entityElement : entity) {
                    entityElement.write(_writable, _cache, _version);
                }
            }
            if (_version >= 1) {
                _writable.writeUnsignedVarint(ops.size() + 1);
                for (OpData opsElement : ops) {
                    opsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(ops.size());
                for (OpData opsElement : ops) {
                    opsElement.write(_writable, _cache, _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 1) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of EntryData");
            }
            {
                if (_version >= 1) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(entity.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (EntityData entityElement : entity) {
                    entityElement.addSize(_size, _cache, _version);
                }
            }
            {
                if (_version >= 1) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(ops.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (OpData opsElement : ops) {
                    opsElement.addSize(_size, _cache, _version);
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
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof EntryData)) return false;
            EntryData other = (EntryData) obj;
            if (this.entity == null) {
                if (other.entity != null) return false;
            } else {
                if (!this.entity.equals(other.entity)) return false;
            }
            if (this.ops == null) {
                if (other.ops != null) return false;
            } else {
                if (!this.ops.equals(other.ops)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (entity == null ? 0 : entity.hashCode());
            hashCode = 31 * hashCode + (ops == null ? 0 : ops.hashCode());
            return hashCode;
        }
        
        @Override
        public EntryData duplicate() {
            EntryData _duplicate = new EntryData();
            ArrayList<EntityData> newEntity = new ArrayList<EntityData>(entity.size());
            for (EntityData _element : entity) {
                newEntity.add(_element.duplicate());
            }
            _duplicate.entity = newEntity;
            ArrayList<OpData> newOps = new ArrayList<OpData>(ops.size());
            for (OpData _element : ops) {
                newOps.add(_element.duplicate());
            }
            _duplicate.ops = newOps;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "EntryData("
                + "entity=" + MessageUtil.deepToString(entity.iterator())
                + ", ops=" + MessageUtil.deepToString(ops.iterator())
                + ")";
        }
        
        public List<EntityData> entity() {
            return this.entity;
        }
        
        public List<OpData> ops() {
            return this.ops;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public EntryData setEntity(List<EntityData> v) {
            this.entity = v;
            return this;
        }
        
        public EntryData setOps(List<OpData> v) {
            this.ops = v;
            return this;
        }
    }
    
    public static class EntityData implements Message {
        String entityType;
        String entityName;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("entity_type", Type.STRING, "The entity type."),
                new Field("entity_name", Type.NULLABLE_STRING, "The name of the entity, or null if the default.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("entity_type", Type.COMPACT_STRING, "The entity type."),
                new Field("entity_name", Type.COMPACT_NULLABLE_STRING, "The name of the entity, or null if the default."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 1;
        
        public EntityData(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public EntityData() {
            this.entityType = "";
            this.entityName = "";
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of EntityData");
            }
            {
                int length;
                if (_version >= 1) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field entityType was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field entityType had invalid length " + length);
                } else {
                    this.entityType = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 1) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.entityName = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field entityName had invalid length " + length);
                } else {
                    this.entityName = _readable.readString(length);
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 1) {
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
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(entityType);
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (entityName == null) {
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeShort((short) -1);
                }
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(entityName);
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 1) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of EntityData");
            }
            {
                byte[] _stringBytes = entityType.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'entityType' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(entityType, _stringBytes);
                if (_version >= 1) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (entityName == null) {
                if (_version >= 1) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(2);
                }
            } else {
                byte[] _stringBytes = entityName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'entityName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(entityName, _stringBytes);
                if (_version >= 1) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
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
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof EntityData)) return false;
            EntityData other = (EntityData) obj;
            if (this.entityType == null) {
                if (other.entityType != null) return false;
            } else {
                if (!this.entityType.equals(other.entityType)) return false;
            }
            if (this.entityName == null) {
                if (other.entityName != null) return false;
            } else {
                if (!this.entityName.equals(other.entityName)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (entityType == null ? 0 : entityType.hashCode());
            hashCode = 31 * hashCode + (entityName == null ? 0 : entityName.hashCode());
            return hashCode;
        }
        
        @Override
        public EntityData duplicate() {
            EntityData _duplicate = new EntityData();
            _duplicate.entityType = entityType;
            if (entityName == null) {
                _duplicate.entityName = null;
            } else {
                _duplicate.entityName = entityName;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "EntityData("
                + "entityType=" + ((entityType == null) ? "null" : "'" + entityType.toString() + "'")
                + ", entityName=" + ((entityName == null) ? "null" : "'" + entityName.toString() + "'")
                + ")";
        }
        
        public String entityType() {
            return this.entityType;
        }
        
        public String entityName() {
            return this.entityName;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public EntityData setEntityType(String v) {
            this.entityType = v;
            return this;
        }
        
        public EntityData setEntityName(String v) {
            this.entityName = v;
            return this;
        }
    }
    
    public static class OpData implements Message {
        String key;
        double value;
        boolean remove;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("key", Type.STRING, "The quota configuration key."),
                new Field("value", Type.FLOAT64, "The value to set, otherwise ignored if the value is to be removed."),
                new Field("remove", Type.BOOLEAN, "Whether the quota configuration value should be removed, otherwise set.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("key", Type.COMPACT_STRING, "The quota configuration key."),
                new Field("value", Type.FLOAT64, "The value to set, otherwise ignored if the value is to be removed."),
                new Field("remove", Type.BOOLEAN, "Whether the quota configuration value should be removed, otherwise set."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 1;
        
        public OpData(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public OpData() {
            this.key = "";
            this.value = 0.0;
            this.remove = false;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 1;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of OpData");
            }
            {
                int length;
                if (_version >= 1) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field key was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field key had invalid length " + length);
                } else {
                    this.key = _readable.readString(length);
                }
            }
            this.value = _readable.readDouble();
            this.remove = _readable.readByte() != 0;
            this._unknownTaggedFields = null;
            if (_version >= 1) {
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
        }
        
        @Override
        public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(key);
                if (_version >= 1) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeDouble(value);
            _writable.writeByte(remove ? (byte) 1 : (byte) 0);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 1) {
                _writable.writeUnsignedVarint(_numTaggedFields);
                _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 1) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of OpData");
            }
            {
                byte[] _stringBytes = key.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'key' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(key, _stringBytes);
                if (_version >= 1) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(8);
            _size.addBytes(1);
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 1) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof OpData)) return false;
            OpData other = (OpData) obj;
            if (this.key == null) {
                if (other.key != null) return false;
            } else {
                if (!this.key.equals(other.key)) return false;
            }
            if (value != other.value) return false;
            if (remove != other.remove) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (key == null ? 0 : key.hashCode());
            hashCode = 31 * hashCode + Double.hashCode(value);
            hashCode = 31 * hashCode + (remove ? 1231 : 1237);
            return hashCode;
        }
        
        @Override
        public OpData duplicate() {
            OpData _duplicate = new OpData();
            _duplicate.key = key;
            _duplicate.value = value;
            _duplicate.remove = remove;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "OpData("
                + "key=" + ((key == null) ? "null" : "'" + key.toString() + "'")
                + ", value=" + value
                + ", remove=" + (remove ? "true" : "false")
                + ")";
        }
        
        public String key() {
            return this.key;
        }
        
        public double value() {
            return this.value;
        }
        
        public boolean remove() {
            return this.remove;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public OpData setKey(String v) {
            this.key = v;
            return this;
        }
        
        public OpData setValue(double v) {
            this.value = v;
            return this;
        }
        
        public OpData setRemove(boolean v) {
            this.remove = v;
            return this;
        }
    }
}
