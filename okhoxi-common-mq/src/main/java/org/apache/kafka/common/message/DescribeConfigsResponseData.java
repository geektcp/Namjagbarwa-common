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


public class DescribeConfigsResponseData implements ApiMessage {
    int throttleTimeMs;
    List<DescribeConfigsResult> results;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeConfigsResult.SCHEMA_0), "The results for each resource.")
        );
    
    public static final Schema SCHEMA_1 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeConfigsResult.SCHEMA_1), "The results for each resource.")
        );
    
    public static final Schema SCHEMA_2 = SCHEMA_1;
    
    public static final Schema SCHEMA_3 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new ArrayOf(DescribeConfigsResult.SCHEMA_3), "The results for each resource.")
        );
    
    public static final Schema SCHEMA_4 =
        new Schema(
            new Field("throttle_time_ms", Type.INT32, "The duration in milliseconds for which the request was throttled due to a quota violation, or zero if the request did not violate any quota."),
            new Field("results", new CompactArrayOf(DescribeConfigsResult.SCHEMA_4), "The results for each resource."),
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
    
    public DescribeConfigsResponseData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public DescribeConfigsResponseData() {
        this.throttleTimeMs = 0;
        this.results = new ArrayList<DescribeConfigsResult>(0);
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
        this.throttleTimeMs = _readable.readInt();
        {
            if (_version >= 4) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field results was serialized as null");
                } else {
                    ArrayList<DescribeConfigsResult> newCollection = new ArrayList<DescribeConfigsResult>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribeConfigsResult(_readable, _version));
                    }
                    this.results = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field results was serialized as null");
                } else {
                    ArrayList<DescribeConfigsResult> newCollection = new ArrayList<DescribeConfigsResult>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new DescribeConfigsResult(_readable, _version));
                    }
                    this.results = newCollection;
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
        _writable.writeInt(throttleTimeMs);
        if (_version >= 4) {
            _writable.writeUnsignedVarint(results.size() + 1);
            for (DescribeConfigsResult resultsElement : results) {
                resultsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(results.size());
            for (DescribeConfigsResult resultsElement : results) {
                resultsElement.write(_writable, _cache, _version);
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
        _size.addBytes(4);
        {
            if (_version >= 4) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(results.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (DescribeConfigsResult resultsElement : results) {
                resultsElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof DescribeConfigsResponseData)) return false;
        DescribeConfigsResponseData other = (DescribeConfigsResponseData) obj;
        if (throttleTimeMs != other.throttleTimeMs) return false;
        if (this.results == null) {
            if (other.results != null) return false;
        } else {
            if (!this.results.equals(other.results)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + throttleTimeMs;
        hashCode = 31 * hashCode + (results == null ? 0 : results.hashCode());
        return hashCode;
    }
    
    @Override
    public DescribeConfigsResponseData duplicate() {
        DescribeConfigsResponseData _duplicate = new DescribeConfigsResponseData();
        _duplicate.throttleTimeMs = throttleTimeMs;
        ArrayList<DescribeConfigsResult> newResults = new ArrayList<DescribeConfigsResult>(results.size());
        for (DescribeConfigsResult _element : results) {
            newResults.add(_element.duplicate());
        }
        _duplicate.results = newResults;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "DescribeConfigsResponseData("
            + "throttleTimeMs=" + throttleTimeMs
            + ", results=" + MessageUtil.deepToString(results.iterator())
            + ")";
    }
    
    public int throttleTimeMs() {
        return this.throttleTimeMs;
    }
    
    public List<DescribeConfigsResult> results() {
        return this.results;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public DescribeConfigsResponseData setThrottleTimeMs(int v) {
        this.throttleTimeMs = v;
        return this;
    }
    
    public DescribeConfigsResponseData setResults(List<DescribeConfigsResult> v) {
        this.results = v;
        return this;
    }
    
    public static class DescribeConfigsResult implements Message {
        short errorCode;
        String errorMessage;
        byte resourceType;
        String resourceName;
        List<DescribeConfigsResourceResult> configs;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configs", new ArrayOf(DescribeConfigsResourceResult.SCHEMA_0), "Each listed configuration.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configs", new ArrayOf(DescribeConfigsResourceResult.SCHEMA_1), "Each listed configuration.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.STRING, "The resource name."),
                new Field("configs", new ArrayOf(DescribeConfigsResourceResult.SCHEMA_3), "Each listed configuration.")
            );
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("error_code", Type.INT16, "The error code, or 0 if we were able to successfully describe the configurations."),
                new Field("error_message", Type.COMPACT_NULLABLE_STRING, "The error message, or null if we were able to successfully describe the configurations."),
                new Field("resource_type", Type.INT8, "The resource type."),
                new Field("resource_name", Type.COMPACT_STRING, "The resource name."),
                new Field("configs", new CompactArrayOf(DescribeConfigsResourceResult.SCHEMA_4), "Each listed configuration."),
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
        
        public DescribeConfigsResult(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribeConfigsResult() {
            this.errorCode = (short) 0;
            this.errorMessage = "";
            this.resourceType = (byte) 0;
            this.resourceName = "";
            this.configs = new ArrayList<DescribeConfigsResourceResult>(0);
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeConfigsResult");
            }
            this.errorCode = _readable.readShort();
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.errorMessage = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field errorMessage had invalid length " + length);
                } else {
                    this.errorMessage = _readable.readString(length);
                }
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
                        throw new RuntimeException("non-nullable field configs was serialized as null");
                    } else {
                        ArrayList<DescribeConfigsResourceResult> newCollection = new ArrayList<DescribeConfigsResourceResult>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribeConfigsResourceResult(_readable, _version));
                        }
                        this.configs = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field configs was serialized as null");
                    } else {
                        ArrayList<DescribeConfigsResourceResult> newCollection = new ArrayList<DescribeConfigsResourceResult>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribeConfigsResourceResult(_readable, _version));
                        }
                        this.configs = newCollection;
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
            _writable.writeShort(errorCode);
            if (errorMessage == null) {
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeShort((short) -1);
                }
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(errorMessage);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
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
                _writable.writeUnsignedVarint(configs.size() + 1);
                for (DescribeConfigsResourceResult configsElement : configs) {
                    configsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(configs.size());
                for (DescribeConfigsResourceResult configsElement : configs) {
                    configsElement.write(_writable, _cache, _version);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribeConfigsResult");
            }
            _size.addBytes(2);
            if (errorMessage == null) {
                if (_version >= 4) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(2);
                }
            } else {
                byte[] _stringBytes = errorMessage.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'errorMessage' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(errorMessage, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
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
            {
                if (_version >= 4) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(configs.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (DescribeConfigsResourceResult configsElement : configs) {
                    configsElement.addSize(_size, _cache, _version);
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
            if (!(obj instanceof DescribeConfigsResult)) return false;
            DescribeConfigsResult other = (DescribeConfigsResult) obj;
            if (errorCode != other.errorCode) return false;
            if (this.errorMessage == null) {
                if (other.errorMessage != null) return false;
            } else {
                if (!this.errorMessage.equals(other.errorMessage)) return false;
            }
            if (resourceType != other.resourceType) return false;
            if (this.resourceName == null) {
                if (other.resourceName != null) return false;
            } else {
                if (!this.resourceName.equals(other.resourceName)) return false;
            }
            if (this.configs == null) {
                if (other.configs != null) return false;
            } else {
                if (!this.configs.equals(other.configs)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + errorCode;
            hashCode = 31 * hashCode + (errorMessage == null ? 0 : errorMessage.hashCode());
            hashCode = 31 * hashCode + resourceType;
            hashCode = 31 * hashCode + (resourceName == null ? 0 : resourceName.hashCode());
            hashCode = 31 * hashCode + (configs == null ? 0 : configs.hashCode());
            return hashCode;
        }
        
        @Override
        public DescribeConfigsResult duplicate() {
            DescribeConfigsResult _duplicate = new DescribeConfigsResult();
            _duplicate.errorCode = errorCode;
            if (errorMessage == null) {
                _duplicate.errorMessage = null;
            } else {
                _duplicate.errorMessage = errorMessage;
            }
            _duplicate.resourceType = resourceType;
            _duplicate.resourceName = resourceName;
            ArrayList<DescribeConfigsResourceResult> newConfigs = new ArrayList<DescribeConfigsResourceResult>(configs.size());
            for (DescribeConfigsResourceResult _element : configs) {
                newConfigs.add(_element.duplicate());
            }
            _duplicate.configs = newConfigs;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResult("
                + "errorCode=" + errorCode
                + ", errorMessage=" + ((errorMessage == null) ? "null" : "'" + errorMessage.toString() + "'")
                + ", resourceType=" + resourceType
                + ", resourceName=" + ((resourceName == null) ? "null" : "'" + resourceName.toString() + "'")
                + ", configs=" + MessageUtil.deepToString(configs.iterator())
                + ")";
        }
        
        public short errorCode() {
            return this.errorCode;
        }
        
        public String errorMessage() {
            return this.errorMessage;
        }
        
        public byte resourceType() {
            return this.resourceType;
        }
        
        public String resourceName() {
            return this.resourceName;
        }
        
        public List<DescribeConfigsResourceResult> configs() {
            return this.configs;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribeConfigsResult setErrorCode(short v) {
            this.errorCode = v;
            return this;
        }
        
        public DescribeConfigsResult setErrorMessage(String v) {
            this.errorMessage = v;
            return this;
        }
        
        public DescribeConfigsResult setResourceType(byte v) {
            this.resourceType = v;
            return this;
        }
        
        public DescribeConfigsResult setResourceName(String v) {
            this.resourceName = v;
            return this;
        }
        
        public DescribeConfigsResult setConfigs(List<DescribeConfigsResourceResult> v) {
            this.configs = v;
            return this;
        }
    }
    
    public static class DescribeConfigsResourceResult implements Message {
        String name;
        String value;
        boolean readOnly;
        boolean isDefault;
        byte configSource;
        boolean isSensitive;
        List<DescribeConfigsSynonym> synonyms;
        byte configType;
        String documentation;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("is_default", Type.BOOLEAN, "True if the configuration is not set."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive.")
            );
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("config_source", Type.INT8, "The configuration source."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive."),
                new Field("synonyms", new ArrayOf(DescribeConfigsSynonym.SCHEMA_1), "The synonyms for this configuration key.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 =
            new Schema(
                new Field("name", Type.STRING, "The configuration name."),
                new Field("value", Type.NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("config_source", Type.INT8, "The configuration source."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive."),
                new Field("synonyms", new ArrayOf(DescribeConfigsSynonym.SCHEMA_1), "The synonyms for this configuration key."),
                new Field("config_type", Type.INT8, "The configuration data type. Type can be one of the following values - BOOLEAN, STRING, INT, SHORT, LONG, DOUBLE, LIST, CLASS, PASSWORD"),
                new Field("documentation", Type.NULLABLE_STRING, "The configuration documentation.")
            );
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The configuration name."),
                new Field("value", Type.COMPACT_NULLABLE_STRING, "The configuration value."),
                new Field("read_only", Type.BOOLEAN, "True if the configuration is read-only."),
                new Field("config_source", Type.INT8, "The configuration source."),
                new Field("is_sensitive", Type.BOOLEAN, "True if this configuration is sensitive."),
                new Field("synonyms", new CompactArrayOf(DescribeConfigsSynonym.SCHEMA_4), "The synonyms for this configuration key."),
                new Field("config_type", Type.INT8, "The configuration data type. Type can be one of the following values - BOOLEAN, STRING, INT, SHORT, LONG, DOUBLE, LIST, CLASS, PASSWORD"),
                new Field("documentation", Type.COMPACT_NULLABLE_STRING, "The configuration documentation."),
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
        
        public DescribeConfigsResourceResult(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribeConfigsResourceResult() {
            this.name = "";
            this.value = "";
            this.readOnly = false;
            this.isDefault = false;
            this.configSource = (byte) -1;
            this.isSensitive = false;
            this.synonyms = new ArrayList<DescribeConfigsSynonym>(0);
            this.configType = (byte) 0;
            this.documentation = "";
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeConfigsResourceResult");
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field name was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.value = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field value had invalid length " + length);
                } else {
                    this.value = _readable.readString(length);
                }
            }
            this.readOnly = _readable.readByte() != 0;
            if (_version <= 0) {
                this.isDefault = _readable.readByte() != 0;
            } else {
                this.isDefault = false;
            }
            if (_version >= 1) {
                this.configSource = _readable.readByte();
            } else {
                this.configSource = (byte) -1;
            }
            this.isSensitive = _readable.readByte() != 0;
            if (_version >= 1) {
                if (_version >= 4) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field synonyms was serialized as null");
                    } else {
                        ArrayList<DescribeConfigsSynonym> newCollection = new ArrayList<DescribeConfigsSynonym>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribeConfigsSynonym(_readable, _version));
                        }
                        this.synonyms = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field synonyms was serialized as null");
                    } else {
                        ArrayList<DescribeConfigsSynonym> newCollection = new ArrayList<DescribeConfigsSynonym>(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new DescribeConfigsSynonym(_readable, _version));
                        }
                        this.synonyms = newCollection;
                    }
                }
            } else {
                this.synonyms = new ArrayList<DescribeConfigsSynonym>(0);
            }
            if (_version >= 3) {
                this.configType = _readable.readByte();
            } else {
                this.configType = (byte) 0;
            }
            if (_version >= 3) {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.documentation = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field documentation had invalid length " + length);
                } else {
                    this.documentation = _readable.readString(length);
                }
            } else {
                this.documentation = "";
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
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (value == null) {
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeShort((short) -1);
                }
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(value);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(readOnly ? (byte) 1 : (byte) 0);
            if (_version <= 0) {
                _writable.writeByte(isDefault ? (byte) 1 : (byte) 0);
            } else {
                if (this.isDefault) {
                    throw new UnsupportedVersionException("Attempted to write a non-default isDefault at version " + _version);
                }
            }
            if (_version >= 1) {
                _writable.writeByte(configSource);
            }
            _writable.writeByte(isSensitive ? (byte) 1 : (byte) 0);
            if (_version >= 1) {
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(synonyms.size() + 1);
                    for (DescribeConfigsSynonym synonymsElement : synonyms) {
                        synonymsElement.write(_writable, _cache, _version);
                    }
                } else {
                    _writable.writeInt(synonyms.size());
                    for (DescribeConfigsSynonym synonymsElement : synonyms) {
                        synonymsElement.write(_writable, _cache, _version);
                    }
                }
            }
            if (_version >= 3) {
                _writable.writeByte(configType);
            }
            if (_version >= 3) {
                if (documentation == null) {
                    if (_version >= 4) {
                        _writable.writeUnsignedVarint(0);
                    } else {
                        _writable.writeShort((short) -1);
                    }
                } else {
                    byte[] _stringBytes = _cache.getSerializedValue(documentation);
                    if (_version >= 4) {
                        _writable.writeUnsignedVarint(_stringBytes.length + 1);
                    } else {
                        _writable.writeShort((short) _stringBytes.length);
                    }
                    _writable.writeByteArray(_stringBytes);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribeConfigsResourceResult");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (value == null) {
                if (_version >= 4) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(2);
                }
            } else {
                byte[] _stringBytes = value.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'value' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(value, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            _size.addBytes(1);
            if (_version <= 0) {
                _size.addBytes(1);
            }
            if (_version >= 1) {
                _size.addBytes(1);
            }
            _size.addBytes(1);
            if (_version >= 1) {
                {
                    if (_version >= 4) {
                        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(synonyms.size() + 1));
                    } else {
                        _size.addBytes(4);
                    }
                    for (DescribeConfigsSynonym synonymsElement : synonyms) {
                        synonymsElement.addSize(_size, _cache, _version);
                    }
                }
            }
            if (_version >= 3) {
                _size.addBytes(1);
            }
            if (_version >= 3) {
                if (documentation == null) {
                    if (_version >= 4) {
                        _size.addBytes(1);
                    } else {
                        _size.addBytes(2);
                    }
                } else {
                    byte[] _stringBytes = documentation.getBytes(StandardCharsets.UTF_8);
                    if (_stringBytes.length > 0x7fff) {
                        throw new RuntimeException("'documentation' field is too long to be serialized");
                    }
                    _cache.cacheSerializedValue(documentation, _stringBytes);
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
            if (!(obj instanceof DescribeConfigsResourceResult)) return false;
            DescribeConfigsResourceResult other = (DescribeConfigsResourceResult) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.value == null) {
                if (other.value != null) return false;
            } else {
                if (!this.value.equals(other.value)) return false;
            }
            if (readOnly != other.readOnly) return false;
            if (isDefault != other.isDefault) return false;
            if (configSource != other.configSource) return false;
            if (isSensitive != other.isSensitive) return false;
            if (this.synonyms == null) {
                if (other.synonyms != null) return false;
            } else {
                if (!this.synonyms.equals(other.synonyms)) return false;
            }
            if (configType != other.configType) return false;
            if (this.documentation == null) {
                if (other.documentation != null) return false;
            } else {
                if (!this.documentation.equals(other.documentation)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
            hashCode = 31 * hashCode + (readOnly ? 1231 : 1237);
            hashCode = 31 * hashCode + (isDefault ? 1231 : 1237);
            hashCode = 31 * hashCode + configSource;
            hashCode = 31 * hashCode + (isSensitive ? 1231 : 1237);
            hashCode = 31 * hashCode + (synonyms == null ? 0 : synonyms.hashCode());
            hashCode = 31 * hashCode + configType;
            hashCode = 31 * hashCode + (documentation == null ? 0 : documentation.hashCode());
            return hashCode;
        }
        
        @Override
        public DescribeConfigsResourceResult duplicate() {
            DescribeConfigsResourceResult _duplicate = new DescribeConfigsResourceResult();
            _duplicate.name = name;
            if (value == null) {
                _duplicate.value = null;
            } else {
                _duplicate.value = value;
            }
            _duplicate.readOnly = readOnly;
            _duplicate.isDefault = isDefault;
            _duplicate.configSource = configSource;
            _duplicate.isSensitive = isSensitive;
            ArrayList<DescribeConfigsSynonym> newSynonyms = new ArrayList<DescribeConfigsSynonym>(synonyms.size());
            for (DescribeConfigsSynonym _element : synonyms) {
                newSynonyms.add(_element.duplicate());
            }
            _duplicate.synonyms = newSynonyms;
            _duplicate.configType = configType;
            if (documentation == null) {
                _duplicate.documentation = null;
            } else {
                _duplicate.documentation = documentation;
            }
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsResourceResult("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", value=" + ((value == null) ? "null" : "'" + value.toString() + "'")
                + ", readOnly=" + (readOnly ? "true" : "false")
                + ", isDefault=" + (isDefault ? "true" : "false")
                + ", configSource=" + configSource
                + ", isSensitive=" + (isSensitive ? "true" : "false")
                + ", synonyms=" + MessageUtil.deepToString(synonyms.iterator())
                + ", configType=" + configType
                + ", documentation=" + ((documentation == null) ? "null" : "'" + documentation.toString() + "'")
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        public boolean readOnly() {
            return this.readOnly;
        }
        
        public boolean isDefault() {
            return this.isDefault;
        }
        
        public byte configSource() {
            return this.configSource;
        }
        
        public boolean isSensitive() {
            return this.isSensitive;
        }
        
        public List<DescribeConfigsSynonym> synonyms() {
            return this.synonyms;
        }
        
        public byte configType() {
            return this.configType;
        }
        
        public String documentation() {
            return this.documentation;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribeConfigsResourceResult setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setValue(String v) {
            this.value = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setReadOnly(boolean v) {
            this.readOnly = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setIsDefault(boolean v) {
            this.isDefault = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setConfigSource(byte v) {
            this.configSource = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setIsSensitive(boolean v) {
            this.isSensitive = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setSynonyms(List<DescribeConfigsSynonym> v) {
            this.synonyms = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setConfigType(byte v) {
            this.configType = v;
            return this;
        }
        
        public DescribeConfigsResourceResult setDocumentation(String v) {
            this.documentation = v;
            return this;
        }
    }
    
    public static class DescribeConfigsSynonym implements Message {
        String name;
        String value;
        byte source;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_1 =
            new Schema(
                new Field("name", Type.STRING, "The synonym name."),
                new Field("value", Type.NULLABLE_STRING, "The synonym value."),
                new Field("source", Type.INT8, "The synonym source.")
            );
        
        public static final Schema SCHEMA_2 = SCHEMA_1;
        
        public static final Schema SCHEMA_3 = SCHEMA_2;
        
        public static final Schema SCHEMA_4 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The synonym name."),
                new Field("value", Type.COMPACT_NULLABLE_STRING, "The synonym value."),
                new Field("source", Type.INT8, "The synonym source."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            null,
            SCHEMA_1,
            SCHEMA_2,
            SCHEMA_3,
            SCHEMA_4
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 1;
        public static final short HIGHEST_SUPPORTED_VERSION = 4;
        
        public DescribeConfigsSynonym(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public DescribeConfigsSynonym() {
            this.name = "";
            this.value = "";
            this.source = (byte) 0;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of DescribeConfigsSynonym");
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field name was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            {
                int length;
                if (_version >= 4) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    this.value = null;
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field value had invalid length " + length);
                } else {
                    this.value = _readable.readString(length);
                }
            }
            this.source = _readable.readByte();
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
            if (_version < 1) {
                throw new UnsupportedVersionException("Can't write version " + _version + " of DescribeConfigsSynonym");
            }
            int _numTaggedFields = 0;
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (value == null) {
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(0);
                } else {
                    _writable.writeShort((short) -1);
                }
            } else {
                byte[] _stringBytes = _cache.getSerializedValue(value);
                if (_version >= 4) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(source);
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
                throw new UnsupportedVersionException("Can't size version " + _version + " of DescribeConfigsSynonym");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            if (value == null) {
                if (_version >= 4) {
                    _size.addBytes(1);
                } else {
                    _size.addBytes(2);
                }
            } else {
                byte[] _stringBytes = value.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'value' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(value, _stringBytes);
                if (_version >= 4) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
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
            if (!(obj instanceof DescribeConfigsSynonym)) return false;
            DescribeConfigsSynonym other = (DescribeConfigsSynonym) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.value == null) {
                if (other.value != null) return false;
            } else {
                if (!this.value.equals(other.value)) return false;
            }
            if (source != other.source) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
            hashCode = 31 * hashCode + source;
            return hashCode;
        }
        
        @Override
        public DescribeConfigsSynonym duplicate() {
            DescribeConfigsSynonym _duplicate = new DescribeConfigsSynonym();
            _duplicate.name = name;
            if (value == null) {
                _duplicate.value = null;
            } else {
                _duplicate.value = value;
            }
            _duplicate.source = source;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "DescribeConfigsSynonym("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", value=" + ((value == null) ? "null" : "'" + value.toString() + "'")
                + ", source=" + source
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public String value() {
            return this.value;
        }
        
        public byte source() {
            return this.source;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public DescribeConfigsSynonym setName(String v) {
            this.name = v;
            return this;
        }
        
        public DescribeConfigsSynonym setValue(String v) {
            this.value = v;
            return this;
        }
        
        public DescribeConfigsSynonym setSource(byte v) {
            this.source = v;
            return this;
        }
    }
}
