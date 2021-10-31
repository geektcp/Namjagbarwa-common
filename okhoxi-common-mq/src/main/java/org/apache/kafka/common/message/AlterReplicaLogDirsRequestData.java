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
import org.apache.kafka.common.protocol.types.ArrayOf;
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


public class AlterReplicaLogDirsRequestData implements ApiMessage {
    AlterReplicaLogDirCollection dirs;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("dirs", new ArrayOf(AlterReplicaLogDir.SCHEMA_0), "The alterations to make for each directory.")
        );
    
    public static final Schema SCHEMA_1 = SCHEMA_0;
    
    public static final Schema SCHEMA_2 =
        new Schema(
            new Field("dirs", new CompactArrayOf(AlterReplicaLogDir.SCHEMA_2), "The alterations to make for each directory."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0,
        SCHEMA_1,
        SCHEMA_2
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 2;
    
    public AlterReplicaLogDirsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public AlterReplicaLogDirsRequestData() {
        this.dirs = new AlterReplicaLogDirCollection(0);
    }
    
    @Override
    public short apiKey() {
        return 34;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 2;
    }
    
    @Override
    public void read(Readable _readable, short _version) {
        {
            if (_version >= 2) {
                int arrayLength;
                arrayLength = _readable.readUnsignedVarint() - 1;
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field dirs was serialized as null");
                } else {
                    AlterReplicaLogDirCollection newCollection = new AlterReplicaLogDirCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new AlterReplicaLogDir(_readable, _version));
                    }
                    this.dirs = newCollection;
                }
            } else {
                int arrayLength;
                arrayLength = _readable.readInt();
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field dirs was serialized as null");
                } else {
                    AlterReplicaLogDirCollection newCollection = new AlterReplicaLogDirCollection(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(new AlterReplicaLogDir(_readable, _version));
                    }
                    this.dirs = newCollection;
                }
            }
        }
        this._unknownTaggedFields = null;
        if (_version >= 2) {
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
        if (_version >= 2) {
            _writable.writeUnsignedVarint(dirs.size() + 1);
            for (AlterReplicaLogDir dirsElement : dirs) {
                dirsElement.write(_writable, _cache, _version);
            }
        } else {
            _writable.writeInt(dirs.size());
            for (AlterReplicaLogDir dirsElement : dirs) {
                dirsElement.write(_writable, _cache, _version);
            }
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        if (_version >= 2) {
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
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(dirs.size() + 1));
            } else {
                _size.addBytes(4);
            }
            for (AlterReplicaLogDir dirsElement : dirs) {
                dirsElement.addSize(_size, _cache, _version);
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
        if (_version >= 2) {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        } else {
            if (_numTaggedFields > 0) {
                throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
            }
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AlterReplicaLogDirsRequestData)) return false;
        AlterReplicaLogDirsRequestData other = (AlterReplicaLogDirsRequestData) obj;
        if (this.dirs == null) {
            if (other.dirs != null) return false;
        } else {
            if (!this.dirs.equals(other.dirs)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (dirs == null ? 0 : dirs.hashCode());
        return hashCode;
    }
    
    @Override
    public AlterReplicaLogDirsRequestData duplicate() {
        AlterReplicaLogDirsRequestData _duplicate = new AlterReplicaLogDirsRequestData();
        AlterReplicaLogDirCollection newDirs = new AlterReplicaLogDirCollection(dirs.size());
        for (AlterReplicaLogDir _element : dirs) {
            newDirs.add(_element.duplicate());
        }
        _duplicate.dirs = newDirs;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "AlterReplicaLogDirsRequestData("
            + "dirs=" + MessageUtil.deepToString(dirs.iterator())
            + ")";
    }
    
    public AlterReplicaLogDirCollection dirs() {
        return this.dirs;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public AlterReplicaLogDirsRequestData setDirs(AlterReplicaLogDirCollection v) {
        this.dirs = v;
        return this;
    }
    
    public static class AlterReplicaLogDir implements Message, ImplicitLinkedHashMultiCollection.Element {
        String path;
        AlterReplicaLogDirTopicCollection topics;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("path", Type.STRING, "The absolute directory path."),
                new Field("topics", new ArrayOf(AlterReplicaLogDirTopic.SCHEMA_0), "The topics to add to the directory.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("path", Type.COMPACT_STRING, "The absolute directory path."),
                new Field("topics", new CompactArrayOf(AlterReplicaLogDirTopic.SCHEMA_2), "The topics to add to the directory."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public AlterReplicaLogDir(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public AlterReplicaLogDir() {
            this.path = "";
            this.topics = new AlterReplicaLogDirTopicCollection(0);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of AlterReplicaLogDir");
            }
            {
                int length;
                if (_version >= 2) {
                    length = _readable.readUnsignedVarint() - 1;
                } else {
                    length = _readable.readShort();
                }
                if (length < 0) {
                    throw new RuntimeException("non-nullable field path was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field path had invalid length " + length);
                } else {
                    this.path = _readable.readString(length);
                }
            }
            {
                if (_version >= 2) {
                    int arrayLength;
                    arrayLength = _readable.readUnsignedVarint() - 1;
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field topics was serialized as null");
                    } else {
                        AlterReplicaLogDirTopicCollection newCollection = new AlterReplicaLogDirTopicCollection(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new AlterReplicaLogDirTopic(_readable, _version));
                        }
                        this.topics = newCollection;
                    }
                } else {
                    int arrayLength;
                    arrayLength = _readable.readInt();
                    if (arrayLength < 0) {
                        throw new RuntimeException("non-nullable field topics was serialized as null");
                    } else {
                        AlterReplicaLogDirTopicCollection newCollection = new AlterReplicaLogDirTopicCollection(arrayLength);
                        for (int i = 0; i < arrayLength; i++) {
                            newCollection.add(new AlterReplicaLogDirTopic(_readable, _version));
                        }
                        this.topics = newCollection;
                    }
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 2) {
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
                byte[] _stringBytes = _cache.getSerializedValue(path);
                if (_version >= 2) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 2) {
                _writable.writeUnsignedVarint(topics.size() + 1);
                for (AlterReplicaLogDirTopic topicsElement : topics) {
                    topicsElement.write(_writable, _cache, _version);
                }
            } else {
                _writable.writeInt(topics.size());
                for (AlterReplicaLogDirTopic topicsElement : topics) {
                    topicsElement.write(_writable, _cache, _version);
                }
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 2) {
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
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of AlterReplicaLogDir");
            }
            {
                byte[] _stringBytes = path.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'path' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(path, _stringBytes);
                if (_version >= 2) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(topics.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                for (AlterReplicaLogDirTopic topicsElement : topics) {
                    topicsElement.addSize(_size, _cache, _version);
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
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof AlterReplicaLogDir)) return false;
            AlterReplicaLogDir other = (AlterReplicaLogDir) obj;
            if (this.path == null) {
                if (other.path != null) return false;
            } else {
                if (!this.path.equals(other.path)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDir)) return false;
            AlterReplicaLogDir other = (AlterReplicaLogDir) obj;
            if (this.path == null) {
                if (other.path != null) return false;
            } else {
                if (!this.path.equals(other.path)) return false;
            }
            if (this.topics == null) {
                if (other.topics != null) return false;
            } else {
                if (!this.topics.equals(other.topics)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (path == null ? 0 : path.hashCode());
            return hashCode;
        }
        
        @Override
        public AlterReplicaLogDir duplicate() {
            AlterReplicaLogDir _duplicate = new AlterReplicaLogDir();
            _duplicate.path = path;
            AlterReplicaLogDirTopicCollection newTopics = new AlterReplicaLogDirTopicCollection(topics.size());
            for (AlterReplicaLogDirTopic _element : topics) {
                newTopics.add(_element.duplicate());
            }
            _duplicate.topics = newTopics;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "AlterReplicaLogDir("
                + "path=" + ((path == null) ? "null" : "'" + path.toString() + "'")
                + ", topics=" + MessageUtil.deepToString(topics.iterator())
                + ")";
        }
        
        public String path() {
            return this.path;
        }
        
        public AlterReplicaLogDirTopicCollection topics() {
            return this.topics;
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
        
        public AlterReplicaLogDir setPath(String v) {
            this.path = v;
            return this;
        }
        
        public AlterReplicaLogDir setTopics(AlterReplicaLogDirTopicCollection v) {
            this.topics = v;
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
    
    public static class AlterReplicaLogDirTopic implements Message, ImplicitLinkedHashMultiCollection.Element {
        String name;
        List<Integer> partitions;
        private List<RawTaggedField> _unknownTaggedFields;
        private int next;
        private int prev;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.STRING, "The topic name."),
                new Field("partitions", new ArrayOf(Type.INT32), "The partition indexes.")
            );
        
        public static final Schema SCHEMA_1 = SCHEMA_0;
        
        public static final Schema SCHEMA_2 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The topic name."),
                new Field("partitions", new CompactArrayOf(Type.INT32), "The partition indexes."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0,
            SCHEMA_1,
            SCHEMA_2
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 2;
        
        public AlterReplicaLogDirTopic(Readable _readable, short _version) {
            read(_readable, _version);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        public AlterReplicaLogDirTopic() {
            this.name = "";
            this.partitions = new ArrayList<Integer>(0);
            this.prev = ImplicitLinkedHashCollection.INVALID_INDEX;
            this.next = ImplicitLinkedHashCollection.INVALID_INDEX;
        }
        
        
        @Override
        public short lowestSupportedVersion() {
            return 0;
        }
        
        @Override
        public short highestSupportedVersion() {
            return 2;
        }
        
        @Override
        public void read(Readable _readable, short _version) {
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't read version " + _version + " of AlterReplicaLogDirTopic");
            }
            {
                int length;
                if (_version >= 2) {
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
                int arrayLength;
                if (_version >= 2) {
                    arrayLength = _readable.readUnsignedVarint() - 1;
                } else {
                    arrayLength = _readable.readInt();
                }
                if (arrayLength < 0) {
                    throw new RuntimeException("non-nullable field partitions was serialized as null");
                } else {
                    ArrayList<Integer> newCollection = new ArrayList<Integer>(arrayLength);
                    for (int i = 0; i < arrayLength; i++) {
                        newCollection.add(_readable.readInt());
                    }
                    this.partitions = newCollection;
                }
            }
            this._unknownTaggedFields = null;
            if (_version >= 2) {
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
                if (_version >= 2) {
                    _writable.writeUnsignedVarint(_stringBytes.length + 1);
                } else {
                    _writable.writeShort((short) _stringBytes.length);
                }
                _writable.writeByteArray(_stringBytes);
            }
            if (_version >= 2) {
                _writable.writeUnsignedVarint(partitions.size() + 1);
            } else {
                _writable.writeInt(partitions.size());
            }
            for (Integer partitionsElement : partitions) {
                _writable.writeInt(partitionsElement);
            }
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            if (_version >= 2) {
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
            if (_version > 2) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of AlterReplicaLogDirTopic");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                if (_version >= 2) {
                    _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
                } else {
                    _size.addBytes(_stringBytes.length + 2);
                }
            }
            {
                if (_version >= 2) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(partitions.size() + 1));
                } else {
                    _size.addBytes(4);
                }
                _size.addBytes(partitions.size() * 4);
            }
            if (_unknownTaggedFields != null) {
                _numTaggedFields += _unknownTaggedFields.size();
                for (RawTaggedField _field : _unknownTaggedFields) {
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                    _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                    _size.addBytes(_field.size());
                }
            }
            if (_version >= 2) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
            } else {
                if (_numTaggedFields > 0) {
                    throw new UnsupportedVersionException("Tagged fields were set, but version " + _version + " of this message does not support them.");
                }
            }
        }
        
        @Override
        public boolean elementKeysAreEqual(Object obj) {
            if (!(obj instanceof AlterReplicaLogDirTopic)) return false;
            AlterReplicaLogDirTopic other = (AlterReplicaLogDirTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            return true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlterReplicaLogDirTopic)) return false;
            AlterReplicaLogDirTopic other = (AlterReplicaLogDirTopic) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (this.partitions == null) {
                if (other.partitions != null) return false;
            } else {
                if (!this.partitions.equals(other.partitions)) return false;
            }
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            return hashCode;
        }
        
        @Override
        public AlterReplicaLogDirTopic duplicate() {
            AlterReplicaLogDirTopic _duplicate = new AlterReplicaLogDirTopic();
            _duplicate.name = name;
            ArrayList<Integer> newPartitions = new ArrayList<Integer>(partitions.size());
            for (Integer _element : partitions) {
                newPartitions.add(_element);
            }
            _duplicate.partitions = newPartitions;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "AlterReplicaLogDirTopic("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", partitions=" + MessageUtil.deepToString(partitions.iterator())
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public List<Integer> partitions() {
            return this.partitions;
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
        
        public AlterReplicaLogDirTopic setName(String v) {
            this.name = v;
            return this;
        }
        
        public AlterReplicaLogDirTopic setPartitions(List<Integer> v) {
            this.partitions = v;
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
    
    public static class AlterReplicaLogDirTopicCollection extends ImplicitLinkedHashMultiCollection<AlterReplicaLogDirTopic> {
        public AlterReplicaLogDirTopicCollection() {
            super();
        }
        
        public AlterReplicaLogDirTopicCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AlterReplicaLogDirTopicCollection(Iterator<AlterReplicaLogDirTopic> iterator) {
            super(iterator);
        }
        
        public AlterReplicaLogDirTopic find(String name) {
            AlterReplicaLogDirTopic _key = new AlterReplicaLogDirTopic();
            _key.setName(name);
            return find(_key);
        }
        
        public List<AlterReplicaLogDirTopic> findAll(String name) {
            AlterReplicaLogDirTopic _key = new AlterReplicaLogDirTopic();
            _key.setName(name);
            return findAll(_key);
        }
        
        public AlterReplicaLogDirTopicCollection duplicate() {
            AlterReplicaLogDirTopicCollection _duplicate = new AlterReplicaLogDirTopicCollection(size());
            for (AlterReplicaLogDirTopic _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
    
    public static class AlterReplicaLogDirCollection extends ImplicitLinkedHashMultiCollection<AlterReplicaLogDir> {
        public AlterReplicaLogDirCollection() {
            super();
        }
        
        public AlterReplicaLogDirCollection(int expectedNumElements) {
            super(expectedNumElements);
        }
        
        public AlterReplicaLogDirCollection(Iterator<AlterReplicaLogDir> iterator) {
            super(iterator);
        }
        
        public AlterReplicaLogDir find(String path) {
            AlterReplicaLogDir _key = new AlterReplicaLogDir();
            _key.setPath(path);
            return find(_key);
        }
        
        public List<AlterReplicaLogDir> findAll(String path) {
            AlterReplicaLogDir _key = new AlterReplicaLogDir();
            _key.setPath(path);
            return findAll(_key);
        }
        
        public AlterReplicaLogDirCollection duplicate() {
            AlterReplicaLogDirCollection _duplicate = new AlterReplicaLogDirCollection(size());
            for (AlterReplicaLogDir _element : this) {
                _duplicate.add(_element.duplicate());
            }
            return _duplicate;
        }
    }
}
