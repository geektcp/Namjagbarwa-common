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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AlterUserScramCredentialsRequestData.*;

public class AlterUserScramCredentialsRequestDataJsonConverter {
    public static AlterUserScramCredentialsRequestData read(JsonNode _node, short _version) {
        AlterUserScramCredentialsRequestData _object = new AlterUserScramCredentialsRequestData();
        JsonNode _deletionsNode = _node.get("deletions");
        if (_deletionsNode == null) {
            throw new RuntimeException("AlterUserScramCredentialsRequestData: unable to locate field 'deletions', which is mandatory in version " + _version);
        } else {
            if (!_deletionsNode.isArray()) {
                throw new RuntimeException("AlterUserScramCredentialsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ScramCredentialDeletion> _collection = new ArrayList<ScramCredentialDeletion>(_deletionsNode.size());
            _object.deletions = _collection;
            for (JsonNode _element : _deletionsNode) {
                _collection.add(ScramCredentialDeletionJsonConverter.read(_element, _version));
            }
        }
        JsonNode _upsertionsNode = _node.get("upsertions");
        if (_upsertionsNode == null) {
            throw new RuntimeException("AlterUserScramCredentialsRequestData: unable to locate field 'upsertions', which is mandatory in version " + _version);
        } else {
            if (!_upsertionsNode.isArray()) {
                throw new RuntimeException("AlterUserScramCredentialsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ScramCredentialUpsertion> _collection = new ArrayList<ScramCredentialUpsertion>(_upsertionsNode.size());
            _object.upsertions = _collection;
            for (JsonNode _element : _upsertionsNode) {
                _collection.add(ScramCredentialUpsertionJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(AlterUserScramCredentialsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _deletionsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ScramCredentialDeletion _element : _object.deletions) {
            _deletionsArray.add(ScramCredentialDeletionJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("deletions", _deletionsArray);
        ArrayNode _upsertionsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ScramCredentialUpsertion _element : _object.upsertions) {
            _upsertionsArray.add(ScramCredentialUpsertionJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("upsertions", _upsertionsArray);
        return _node;
    }
    public static JsonNode write(AlterUserScramCredentialsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ScramCredentialDeletionJsonConverter {
        public static ScramCredentialDeletion read(JsonNode _node, short _version) {
            ScramCredentialDeletion _object = new ScramCredentialDeletion();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("ScramCredentialDeletion: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("ScramCredentialDeletion expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _mechanismNode = _node.get("mechanism");
            if (_mechanismNode == null) {
                throw new RuntimeException("ScramCredentialDeletion: unable to locate field 'mechanism', which is mandatory in version " + _version);
            } else {
                _object.mechanism = MessageUtil.jsonNodeToByte(_mechanismNode, "ScramCredentialDeletion");
            }
            return _object;
        }
        public static JsonNode write(ScramCredentialDeletion _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("mechanism", new ShortNode(_object.mechanism));
            return _node;
        }
        public static JsonNode write(ScramCredentialDeletion _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class ScramCredentialUpsertionJsonConverter {
        public static ScramCredentialUpsertion read(JsonNode _node, short _version) {
            ScramCredentialUpsertion _object = new ScramCredentialUpsertion();
            JsonNode _nameNode = _node.get("name");
            if (_nameNode == null) {
                throw new RuntimeException("ScramCredentialUpsertion: unable to locate field 'name', which is mandatory in version " + _version);
            } else {
                if (!_nameNode.isTextual()) {
                    throw new RuntimeException("ScramCredentialUpsertion expected a string type, but got " + _node.getNodeType());
                }
                _object.name = _nameNode.asText();
            }
            JsonNode _mechanismNode = _node.get("mechanism");
            if (_mechanismNode == null) {
                throw new RuntimeException("ScramCredentialUpsertion: unable to locate field 'mechanism', which is mandatory in version " + _version);
            } else {
                _object.mechanism = MessageUtil.jsonNodeToByte(_mechanismNode, "ScramCredentialUpsertion");
            }
            JsonNode _iterationsNode = _node.get("iterations");
            if (_iterationsNode == null) {
                throw new RuntimeException("ScramCredentialUpsertion: unable to locate field 'iterations', which is mandatory in version " + _version);
            } else {
                _object.iterations = MessageUtil.jsonNodeToInt(_iterationsNode, "ScramCredentialUpsertion");
            }
            JsonNode _saltNode = _node.get("salt");
            if (_saltNode == null) {
                throw new RuntimeException("ScramCredentialUpsertion: unable to locate field 'salt', which is mandatory in version " + _version);
            } else {
                _object.salt = MessageUtil.jsonNodeToBinary(_saltNode, "ScramCredentialUpsertion");
            }
            JsonNode _saltedPasswordNode = _node.get("saltedPassword");
            if (_saltedPasswordNode == null) {
                throw new RuntimeException("ScramCredentialUpsertion: unable to locate field 'saltedPassword', which is mandatory in version " + _version);
            } else {
                _object.saltedPassword = MessageUtil.jsonNodeToBinary(_saltedPasswordNode, "ScramCredentialUpsertion");
            }
            return _object;
        }
        public static JsonNode write(ScramCredentialUpsertion _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("name", new TextNode(_object.name));
            _node.set("mechanism", new ShortNode(_object.mechanism));
            _node.set("iterations", new IntNode(_object.iterations));
            _node.set("salt", new BinaryNode(Arrays.copyOf(_object.salt, _object.salt.length)));
            _node.set("saltedPassword", new BinaryNode(Arrays.copyOf(_object.saltedPassword, _object.saltedPassword.length)));
            return _node;
        }
        public static JsonNode write(ScramCredentialUpsertion _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
