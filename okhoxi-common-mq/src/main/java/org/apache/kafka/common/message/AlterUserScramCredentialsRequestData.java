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
import java.util.Arrays;
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
import org.apache.kafka.common.utils.Bytes;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class AlterUserScramCredentialsRequestData implements ApiMessage {
    List<ScramCredentialDeletion> deletions;
    List<ScramCredentialUpsertion> upsertions;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("deletions", new CompactArrayOf(ScramCredentialDeletion.SCHEMA_0), "The SCRAM credentials to remove."),
            new Field("upsertions", new CompactArrayOf(ScramCredentialUpsertion.SCHEMA_0), "The SCRAM credentials to update/insert."),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public AlterUserScramCredentialsRequestData(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public AlterUserScramCredentialsRequestData() {
        this.deletions = new ArrayList<ScramCredentialDeletion>(0);
        this.upsertions = new ArrayList<ScramCredentialUpsertion>(0);
    }
    
    @Override
    public short apiKey() {
        return 51;
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
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field deletions was serialized as null");
            } else {
                ArrayList<ScramCredentialDeletion> newCollection = new ArrayList<ScramCredentialDeletion>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new ScramCredentialDeletion(_readable, _version));
                }
                this.deletions = newCollection;
            }
        }
        {
            int arrayLength;
            arrayLength = _readable.readUnsignedVarint() - 1;
            if (arrayLength < 0) {
                throw new RuntimeException("non-nullable field upsertions was serialized as null");
            } else {
                ArrayList<ScramCredentialUpsertion> newCollection = new ArrayList<ScramCredentialUpsertion>(arrayLength);
                for (int i = 0; i < arrayLength; i++) {
                    newCollection.add(new ScramCredentialUpsertion(_readable, _version));
                }
                this.upsertions = newCollection;
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
        _writable.writeUnsignedVarint(deletions.size() + 1);
        for (ScramCredentialDeletion deletionsElement : deletions) {
            deletionsElement.write(_writable, _cache, _version);
        }
        _writable.writeUnsignedVarint(upsertions.size() + 1);
        for (ScramCredentialUpsertion upsertionsElement : upsertions) {
            upsertionsElement.write(_writable, _cache, _version);
        }
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(deletions.size() + 1));
            for (ScramCredentialDeletion deletionsElement : deletions) {
                deletionsElement.addSize(_size, _cache, _version);
            }
        }
        {
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(upsertions.size() + 1));
            for (ScramCredentialUpsertion upsertionsElement : upsertions) {
                upsertionsElement.addSize(_size, _cache, _version);
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
        if (!(obj instanceof AlterUserScramCredentialsRequestData)) return false;
        AlterUserScramCredentialsRequestData other = (AlterUserScramCredentialsRequestData) obj;
        if (this.deletions == null) {
            if (other.deletions != null) return false;
        } else {
            if (!this.deletions.equals(other.deletions)) return false;
        }
        if (this.upsertions == null) {
            if (other.upsertions != null) return false;
        } else {
            if (!this.upsertions.equals(other.upsertions)) return false;
        }
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + (deletions == null ? 0 : deletions.hashCode());
        hashCode = 31 * hashCode + (upsertions == null ? 0 : upsertions.hashCode());
        return hashCode;
    }
    
    @Override
    public AlterUserScramCredentialsRequestData duplicate() {
        AlterUserScramCredentialsRequestData _duplicate = new AlterUserScramCredentialsRequestData();
        ArrayList<ScramCredentialDeletion> newDeletions = new ArrayList<ScramCredentialDeletion>(deletions.size());
        for (ScramCredentialDeletion _element : deletions) {
            newDeletions.add(_element.duplicate());
        }
        _duplicate.deletions = newDeletions;
        ArrayList<ScramCredentialUpsertion> newUpsertions = new ArrayList<ScramCredentialUpsertion>(upsertions.size());
        for (ScramCredentialUpsertion _element : upsertions) {
            newUpsertions.add(_element.duplicate());
        }
        _duplicate.upsertions = newUpsertions;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "AlterUserScramCredentialsRequestData("
            + "deletions=" + MessageUtil.deepToString(deletions.iterator())
            + ", upsertions=" + MessageUtil.deepToString(upsertions.iterator())
            + ")";
    }
    
    public List<ScramCredentialDeletion> deletions() {
        return this.deletions;
    }
    
    public List<ScramCredentialUpsertion> upsertions() {
        return this.upsertions;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public AlterUserScramCredentialsRequestData setDeletions(List<ScramCredentialDeletion> v) {
        this.deletions = v;
        return this;
    }
    
    public AlterUserScramCredentialsRequestData setUpsertions(List<ScramCredentialUpsertion> v) {
        this.upsertions = v;
        return this;
    }
    
    public static class ScramCredentialDeletion implements Message {
        String name;
        byte mechanism;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The user name."),
                new Field("mechanism", Type.INT8, "The SCRAM mechanism."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public ScramCredentialDeletion(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ScramCredentialDeletion() {
            this.name = "";
            this.mechanism = (byte) 0;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ScramCredentialDeletion");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field name was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            this.mechanism = _readable.readByte();
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
                byte[] _stringBytes = _cache.getSerializedValue(name);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(mechanism);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of ScramCredentialDeletion");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
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
            _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ScramCredentialDeletion)) return false;
            ScramCredentialDeletion other = (ScramCredentialDeletion) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (mechanism != other.mechanism) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + mechanism;
            return hashCode;
        }
        
        @Override
        public ScramCredentialDeletion duplicate() {
            ScramCredentialDeletion _duplicate = new ScramCredentialDeletion();
            _duplicate.name = name;
            _duplicate.mechanism = mechanism;
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ScramCredentialDeletion("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", mechanism=" + mechanism
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public byte mechanism() {
            return this.mechanism;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ScramCredentialDeletion setName(String v) {
            this.name = v;
            return this;
        }
        
        public ScramCredentialDeletion setMechanism(byte v) {
            this.mechanism = v;
            return this;
        }
    }
    
    public static class ScramCredentialUpsertion implements Message {
        String name;
        byte mechanism;
        int iterations;
        byte[] salt;
        byte[] saltedPassword;
        private List<RawTaggedField> _unknownTaggedFields;
        
        public static final Schema SCHEMA_0 =
            new Schema(
                new Field("name", Type.COMPACT_STRING, "The user name."),
                new Field("mechanism", Type.INT8, "The SCRAM mechanism."),
                new Field("iterations", Type.INT32, "The number of iterations."),
                new Field("salt", Type.COMPACT_BYTES, "A random salt generated by the client."),
                new Field("salted_password", Type.COMPACT_BYTES, "The salted password."),
                TaggedFieldsSection.of(
                )
            );
        
        public static final Schema[] SCHEMAS = new Schema[] {
            SCHEMA_0
        };
        
        public static final short LOWEST_SUPPORTED_VERSION = 0;
        public static final short HIGHEST_SUPPORTED_VERSION = 0;
        
        public ScramCredentialUpsertion(Readable _readable, short _version) {
            read(_readable, _version);
        }
        
        public ScramCredentialUpsertion() {
            this.name = "";
            this.mechanism = (byte) 0;
            this.iterations = 0;
            this.salt = Bytes.EMPTY;
            this.saltedPassword = Bytes.EMPTY;
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
                throw new UnsupportedVersionException("Can't read version " + _version + " of ScramCredentialUpsertion");
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field name was serialized as null");
                } else if (length > 0x7fff) {
                    throw new RuntimeException("string field name had invalid length " + length);
                } else {
                    this.name = _readable.readString(length);
                }
            }
            this.mechanism = _readable.readByte();
            this.iterations = _readable.readInt();
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field salt was serialized as null");
                } else {
                    byte[] newBytes = new byte[length];
                    _readable.readArray(newBytes);
                    this.salt = newBytes;
                }
            }
            {
                int length;
                length = _readable.readUnsignedVarint() - 1;
                if (length < 0) {
                    throw new RuntimeException("non-nullable field saltedPassword was serialized as null");
                } else {
                    byte[] newBytes = new byte[length];
                    _readable.readArray(newBytes);
                    this.saltedPassword = newBytes;
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
            {
                byte[] _stringBytes = _cache.getSerializedValue(name);
                _writable.writeUnsignedVarint(_stringBytes.length + 1);
                _writable.writeByteArray(_stringBytes);
            }
            _writable.writeByte(mechanism);
            _writable.writeInt(iterations);
            _writable.writeUnsignedVarint(salt.length + 1);
            _writable.writeByteArray(salt);
            _writable.writeUnsignedVarint(saltedPassword.length + 1);
            _writable.writeByteArray(saltedPassword);
            RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
            _numTaggedFields += _rawWriter.numFields();
            _writable.writeUnsignedVarint(_numTaggedFields);
            _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
        }
        
        @Override
        public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
            int _numTaggedFields = 0;
            if (_version > 0) {
                throw new UnsupportedVersionException("Can't size version " + _version + " of ScramCredentialUpsertion");
            }
            {
                byte[] _stringBytes = name.getBytes(StandardCharsets.UTF_8);
                if (_stringBytes.length > 0x7fff) {
                    throw new RuntimeException("'name' field is too long to be serialized");
                }
                _cache.cacheSerializedValue(name, _stringBytes);
                _size.addBytes(_stringBytes.length + ByteUtils.sizeOfUnsignedVarint(_stringBytes.length + 1));
            }
            _size.addBytes(1);
            _size.addBytes(4);
            {
                _size.addBytes(salt.length);
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(salt.length + 1));
            }
            {
                _size.addBytes(saltedPassword.length);
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(saltedPassword.length + 1));
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
            if (!(obj instanceof ScramCredentialUpsertion)) return false;
            ScramCredentialUpsertion other = (ScramCredentialUpsertion) obj;
            if (this.name == null) {
                if (other.name != null) return false;
            } else {
                if (!this.name.equals(other.name)) return false;
            }
            if (mechanism != other.mechanism) return false;
            if (iterations != other.iterations) return false;
            if (!Arrays.equals(this.salt, other.salt)) return false;
            if (!Arrays.equals(this.saltedPassword, other.saltedPassword)) return false;
            return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
            hashCode = 31 * hashCode + mechanism;
            hashCode = 31 * hashCode + iterations;
            hashCode = 31 * hashCode + Arrays.hashCode(salt);
            hashCode = 31 * hashCode + Arrays.hashCode(saltedPassword);
            return hashCode;
        }
        
        @Override
        public ScramCredentialUpsertion duplicate() {
            ScramCredentialUpsertion _duplicate = new ScramCredentialUpsertion();
            _duplicate.name = name;
            _duplicate.mechanism = mechanism;
            _duplicate.iterations = iterations;
            _duplicate.salt = MessageUtil.duplicate(salt);
            _duplicate.saltedPassword = MessageUtil.duplicate(saltedPassword);
            return _duplicate;
        }
        
        @Override
        public String toString() {
            return "ScramCredentialUpsertion("
                + "name=" + ((name == null) ? "null" : "'" + name.toString() + "'")
                + ", mechanism=" + mechanism
                + ", iterations=" + iterations
                + ", salt=" + Arrays.toString(salt)
                + ", saltedPassword=" + Arrays.toString(saltedPassword)
                + ")";
        }
        
        public String name() {
            return this.name;
        }
        
        public byte mechanism() {
            return this.mechanism;
        }
        
        public int iterations() {
            return this.iterations;
        }
        
        public byte[] salt() {
            return this.salt;
        }
        
        public byte[] saltedPassword() {
            return this.saltedPassword;
        }
        
        @Override
        public List<RawTaggedField> unknownTaggedFields() {
            if (_unknownTaggedFields == null) {
                _unknownTaggedFields = new ArrayList<>(0);
            }
            return _unknownTaggedFields;
        }
        
        public ScramCredentialUpsertion setName(String v) {
            this.name = v;
            return this;
        }
        
        public ScramCredentialUpsertion setMechanism(byte v) {
            this.mechanism = v;
            return this;
        }
        
        public ScramCredentialUpsertion setIterations(int v) {
            this.iterations = v;
            return this;
        }
        
        public ScramCredentialUpsertion setSalt(byte[] v) {
            this.salt = v;
            return this;
        }
        
        public ScramCredentialUpsertion setSaltedPassword(byte[] v) {
            this.saltedPassword = v;
            return this;
        }
    }
}
