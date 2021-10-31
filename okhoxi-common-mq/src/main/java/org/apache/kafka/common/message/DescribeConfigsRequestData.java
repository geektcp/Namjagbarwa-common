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


public class DescribeConfigsRequestData implements ApiMessage {
    List<DescribeConfigsResource> resources;
    boolean includeSynonyms;
    boolean includeDocumentation;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("resources", new ArrayOf(DescribeConfigsResource.SCHEMA_0), "The resources whose configurations we want to describe.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("resources", new ArrayOf(DescribeConfigsResource.SCHEMA_0), "The resources whose configurations we want to describe."),
            new Field("include_synonyms", Type.BOOLEAN, "True if we should include all synonyms.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("resources", new ArrayOf(DescribeConfigsResource.SCHEMA_0), "The resources whose configurations we want to describe."),
            new Field("include_synonyms", Type.BOOLEAN, "True if we should include all synonyms."),
            new Field("include_documentation", Type.BOOLEAN, "True if we should include configuration documentation.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("resources", new CompactArrayOf(DescribeConfigsResource.SCHEMA_4), "The resources whose configurations we want to describe."),
            new Field("include_synonyms", Type.BOOLEAN, "True if we should include all synonyms."),
            new Field("include_documentation", Type.BOOLEAN, "True if we should include configuration documentation."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2,
        SCHEMA_3,
        SCHEMA_4
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 4;
    
    public DescribeConfigsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DescribeConfigsRequestData() {
        this.resources = new ArrayList<DescribeConfigsResource>(0);
        this.includeSynonyms = false;
        this.includeDocumentation = false;
    }
    
    @Override
    public short apiKey() {
        return 32;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 4;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field resources was serialized as null");
                } else {
                    ArrayList<DescribeConfigsResource> newCollection = new ArrayList<DescribeConfigsResource>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribeConfigsResource(_readable, _version));
                    }
                    this.resources = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field resources was serialized as null");
                } else {
                    ArrayList<DescribeConfigsResource> newCollection = new ArrayList<DescribeConfigsResource>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribeConfigsResource(_readable, _version));
                    }
                    this.resources = newCollection;
                }
            }
        }
        if (_version >= 1) {
            this.includeSynonyms = _readable.readByte() != 0;
        } else {
            this.includeSynonyms = false;
        }
        if (_version >= 3) {
            this.includeDocumentation = _readable.readByte() != 0;
        } else {
            this.includeDocumentation = false;
        }
        this._unknownTaggedFields = null;
        if (_version >= 4) {
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
        if (_version >= 4) {
            _writable.writeUnsignedVarint(resources.size() + 1);
            for (DescribeConfigsResource resourcesElement : resources) {
                resourcesElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(resources.size());
            for (DescribeConfigsResource resourcesElement : resources) {
                resourcesElement.write(_writable, _cache, _version);
            }
        }
        if (_version >= 1) {
            _writable.writeByte(includeSynonyms ? (byte) 1 : (byte) 0);
        } else {
            if (this.includeSynonyms) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeSynonyms at version " + _version);
            }
        }
        if (_version >= 3) {
            _writable.writeByte(includeDocumentation ? (byte) 1 : (byte) 0);
        } else {
            if (this.includeDocumentation) {
                throw new UnsupportedVersionException("Attempted to write a non-default includeDocumentation at version " + _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 4) {
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
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(resources.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (DescribeConfigsResource resourcesElement : resources) {
                resourcesElement.addSize(_size, _cache, _version);
            }
        }
        if (_version >= 1) {
            _size.addBytes(1);
        }
        if (_version >= 3) {
            _size.addBytes(1);
        }
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        if (_version >= 4) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DescribeConfigsRequestData)) return false;
        DescribeConfigsRequestData other = (DescribeConfigsRequestData) obj;
        if (this.resources == null) {
            if (other.resources != null) return false;
        } else {
            if (!this.resources.equals(other.resources)) return false;
        }
        if (includeSynonyms != other.includeSynonyms) return false;
        if (includeDocumentation != other.includeDocumentation) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (resources == null ? 0 : resources.hashCode());
        hashCode = 31 * hashCode + (includeSynonyms ? 1231 : 1237);
        hashCode = 31 * hashCode + (includeDocumentation ? 1231 : 1237);
        return hashCode;
    }
    
    @Override
    public DescribeConfigsRequestData duplicate() {
        DescribeConfigsRequestData _duplicate = new DescribeConfigsRequestData();
        ArrayList<DescribeConfigsResource> newResources = new ArrayList<DescribeConfigsResource>(resources.size());
        for (DescribeConfigsResource _element : resources) {
            newResources.add(_element.duplicate());
        }
        _duplicate.resources = newResources;
        _duplicate.includeSynonyms = includeSynonyms;
        _duplicate.includeDocumentation = includeDocumentation;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DescribeConfigsRequestData("
            + "resources=" + MessageUtil.deepToString(resources.iterator())
            + ", includeSynonyms=" + (includeSynonyms ? "true" : "false")
            + ", includeDocumentation=" + (includeDocumentation ? "true" : "false")
            + ")";
    }
    
    public List<DescribeConfigsResource> resources() {
        return this.resources;
    }
    
    public boolean includeSynonyms() {
        return this.includeSynonyms;
    }
    
    public boolean includeDocumentation() {
        return this.includeDocumentation;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DescribeConfigsRequestData setResources(List<DescribeConfigsResource> v) {
        this.resources = v;
        return this;
    }
    
    public DescribeConfigsRequestData setIncludeSynonyms(boolean v) {
        this.includeSynonyms = v;
        return this;
    }
    
    public DescribeConfigsRequestData setIncludeDocumentation(boolean v) {
        this.includeDocumentation = v;
        return this;
    }
    
    public static class DescribeConfigsResource implements Message {
        byte resourceType;
        String resourceName;
        List<String> configurationKeys;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configuration_keys", ArrayOf.nullable(Type.STRING), "The configuration keys to list, or null to list all configuration keys.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.COMPACT_STRING, "The resource name."),
                new Field("configuration_keys", CompactArrayOf.nullable(Type.COMPACT_STRING), "The configuration keys to list, or null to list all configuration keys."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 4;
        
        public DescribeConfigsResource(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribeConfigsResource() {
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.configurationKeys = new ArrayList<String>(0);
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 4;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeConfigsResource");
            }
            this.resourceType = _readable.readByte();
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field resourceName was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field resourceName had invalid length " + length);
                } else {
                    this.resourceName = _readable.readString(length);
                }
            }
            {
                if (_version >= 4) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        this.configurationKeys = null;
                    } else {
                        ArrayList<String> newCollection = new ArrayList<String>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            int length;
                            length = _readable.readUnsignedVarint() - 1;
                            if (length < 0) {
                                throw new RuntimeException("non-nullable field configurationKeys element was serialized as null");
                            } else if (length > 0x7fff) {
                                throw new RuntimeException("string field configurationKeys element had invalid length " + length);
                            } else {
                                newCollection.add(_readable.readString(length));
                            }
                        }
                        this.configurationKeys = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        this.configurationKeys = null;
                    } else {
                        ArrayList<String> newCollection = new ArrayList<String>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            int length;
                            length = _readable.readShort();
                            if (length < 0) {
                                throw new RuntimeException("non-nullable field configurationKeys element was serialized as null");
                            } else if (length > 0x7fff) {
                                throw new RuntimeException("string field configurationKeys element had invalid length " + length);
                            } else {
                                newCollection.add(_readable.readString(length));
                            }
                        }
                        this.configurationKeys = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 4) {
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
            _writable.writeByte(resourceType);
            {
                byte[] _stringBytes = _cache.getSerializedValue(resourceName);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 4) {
                if (configurationKeys == null) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeUnsignedVarint(configurationKeys.size() + 1);
                    for (String configurationKeysElement : configurationKeys) {
                        {
                            byte[] _stringBytes = _cache.getSerializedValue(configurationKeysElement);
                            _writable.writeUnsignedVarint(_stringBytes.length + 1);
                            _writable.writeByteArray(_stringBytes);
                        }
                    }
                }
            } else {
                if (configurationKeys == null) {
                    _writable.writeInt(-1);
                } else {
                    _writable.writeInt(configurationKeys.size());
                    for (String configurationKeysElement : configurationKeys) {
                        {
                            byte[] _stringBytes = _cache.getSerializedValue(configurationKeysElement);
                            _writable.writeShort((short) _stringBytes.length);
                            _writable.writeByteArray(_stringBytes);
                        }
                    }
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 4) {
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
            if (_version > 4) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribeConfigsResource");
            }
            _size.addBytes(1);
            {
                byte[] _stringBytes = resourceName.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'resourceName' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(resourceName, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (configurationKeys == null) {
                if (_version >= 4) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(4);
                }
            } else {
                if (_version >= 4) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(configurationKeys.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (String configurationKeysElement : configurationKeys) {
                    byte[] _stringBytes = configurationKeysElement.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'configurationKeysElement' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(configurationKeysElement, _stringBytes);
                    if (_version >= 4) {
                        _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                    } else {
                        _size.addBytes(_stringBytes.length + 2);
                    }
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
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof DescribeConfigsResource)) return false;
            DescribeConfigsResource other = (DescribeConfigsResource) obj;
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (this.configurationKeys == null) {
                if (other.configurationKeys != null) return false;
            } else {
                if (!this.configurationKeys.equals(other.configurationKeys)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + (configurationKeys == null ? 0 : configurationKeys.hashCode());
            return hashCode;
        }
        
        @Override
        public DescribeConfigsResource duplicate() {
            DescribeConfigsResource _duplicate = new DescribeConfigsResource();
            _duplicate.resourceType = resourceType;
            _duplicate.resourceName = resourceName;
            if (configurationKeys == null) {
                _duplicate.configurationKeys = null;
            } else {
                ArrayList<String> newConfigurationKeys = new ArrayList<String>(configurationKeys.size());
                for (String _element : configurationKeys) {
                    newConfigurationKeys.add(_element);
                }
                _duplicate.configurationKeys = newConfigurationKeys;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResource("
                + "resourceType=" + resourceType
                + ", resourceName=" + ((resourceName == null) ? "null" : "'" + resourceName.toString() + "'")
                + ", configurationKeys=" + ((configurationKeys == null) ? "null" : MessageUtil.deepToString(configurationKeys.iterator()))
                + ")";
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public List<String> configurationKeys() {
            return this.configurationKeys;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribeConfigsResource setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public DescribeConfigsResource setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public DescribeConfigsResource setConfigurationKeys(List<String> v) {
            this.configurationKeys = v;
            return this;
        }
    }
}
