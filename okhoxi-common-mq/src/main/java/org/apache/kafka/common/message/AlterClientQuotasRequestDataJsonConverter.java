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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.AlterClientQuotasRequestData.*;

public class AlterClientQuotasRequestDataJsonConverter {
    public static AlterClientQuotasRequestData read(JsonNode _node, short _version) {
        AlterClientQuotasRequestData _object = new AlterClientQuotasRequestData();
        JsonNode _entriesNode = _node.get("entries");
        if (_entriesNode == null) {
            throw new RuntimeException("AlterClientQuotasRequestData: unable to locate field 'entries', which is mandatory in version " + _version);
        } else {
            if (!_entriesNode.isArray()) {
                throw new RuntimeException("AlterClientQuotasRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<EntryData> _collection = new ArrayList<EntryData>(_entriesNode.size());
            _object.entries = _collection;
            for (JsonNode _element : _entriesNode) {
                _collection.add(EntryDataJsonConverter.read(_element, _version));
            }
        }
        JsonNode _validateOnlyNode = _node.get("validateOnly");
        if (_validateOnlyNode == null) {
            throw new RuntimeException("AlterClientQuotasRequestData: unable to locate field 'validateOnly', which is mandatory in version " + _version);
        } else {
            if (!_validateOnlyNode.isBoolean()) {
                throw new RuntimeException("AlterClientQuotasRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.validateOnly = _validateOnlyNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(AlterClientQuotasRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _entriesArray = new ArrayNode(JsonNodeFactory.instance);
        for (EntryData _element : _object.entries) {
            _entriesArray.add(EntryDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("entries", _entriesArray);
        _node.set("validateOnly", BooleanNode.valueOf(_object.validateOnly));
        return _node;
    }
    public static JsonNode write(AlterClientQuotasRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class EntityDataJsonConverter {
        public static EntityData read(JsonNode _node, short _version) {
            EntityData _object = new EntityData();
            JsonNode _entityTypeNode = _node.get("entityType");
            if (_entityTypeNode == null) {
                throw new RuntimeException("EntityData: unable to locate field 'entityType', which is mandatory in version " + _version);
            } else {
                if (!_entityTypeNode.isTextual()) {
                    throw new RuntimeException("EntityData expected a string type, but got " + _node.getNodeType());
                }
                _object.entityType = _entityTypeNode.asText();
            }
            JsonNode _entityNameNode = _node.get("entityName");
            if (_entityNameNode == null) {
                throw new RuntimeException("EntityData: unable to locate field 'entityName', which is mandatory in version " + _version);
            } else {
                if (_entityNameNode.isNull()) {
                    _object.entityName = null;
                } else {
                    if (!_entityNameNode.isTextual()) {
                        throw new RuntimeException("EntityData expected a string type, but got " + _node.getNodeType());
                    }
                    _object.entityName = _entityNameNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(EntityData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("entityType", new TextNode(_object.entityType));
            if (_object.entityName == null) {
                _node.set("entityName", NullNode.instance);
            } else {
                _node.set("entityName", new TextNode(_object.entityName));
            }
            return _node;
        }
        public static JsonNode write(EntityData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class EntryDataJsonConverter {
        public static EntryData read(JsonNode _node, short _version) {
            EntryData _object = new EntryData();
            JsonNode _entityNode = _node.get("entity");
            if (_entityNode == null) {
                throw new RuntimeException("EntryData: unable to locate field 'entity', which is mandatory in version " + _version);
            } else {
                if (!_entityNode.isArray()) {
                    throw new RuntimeException("EntryData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<EntityData> _collection = new ArrayList<EntityData>(_entityNode.size());
                _object.entity = _collection;
                for (JsonNode _element : _entityNode) {
                    _collection.add(EntityDataJsonConverter.read(_element, _version));
                }
            }
            JsonNode _opsNode = _node.get("ops");
            if (_opsNode == null) {
                throw new RuntimeException("EntryData: unable to locate field 'ops', which is mandatory in version " + _version);
            } else {
                if (!_opsNode.isArray()) {
                    throw new RuntimeException("EntryData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<OpData> _collection = new ArrayList<OpData>(_opsNode.size());
                _object.ops = _collection;
                for (JsonNode _element : _opsNode) {
                    _collection.add(OpDataJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(EntryData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            ArrayNode _entityArray = new ArrayNode(JsonNodeFactory.instance);
            for (EntityData _element : _object.entity) {
                _entityArray.add(EntityDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("entity", _entityArray);
            ArrayNode _opsArray = new ArrayNode(JsonNodeFactory.instance);
            for (OpData _element : _object.ops) {
                _opsArray.add(OpDataJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("ops", _opsArray);
            return _node;
        }
        public static JsonNode write(EntryData _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class OpDataJsonConverter {
        public static OpData read(JsonNode _node, short _version) {
            OpData _object = new OpData();
            JsonNode _keyNode = _node.get("key");
            if (_keyNode == null) {
                throw new RuntimeException("OpData: unable to locate field 'key', which is mandatory in version " + _version);
            } else {
                if (!_keyNode.isTextual()) {
                    throw new RuntimeException("OpData expected a string type, but got " + _node.getNodeType());
                }
                _object.key = _keyNode.asText();
            }
            JsonNode _valueNode = _node.get("value");
            if (_valueNode == null) {
                throw new RuntimeException("OpData: unable to locate field 'value', which is mandatory in version " + _version);
            } else {
                _object.value = MessageUtil.jsonNodeToDouble(_valueNode, "OpData");
            }
            JsonNode _removeNode = _node.get("remove");
            if (_removeNode == null) {
                throw new RuntimeException("OpData: unable to locate field 'remove', which is mandatory in version " + _version);
            } else {
                if (!_removeNode.isBoolean()) {
                    throw new RuntimeException("OpData expected Boolean type, but got " + _node.getNodeType());
                }
                _object.remove = _removeNode.asBoolean();
            }
            return _object;
        }
        public static JsonNode write(OpData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("key", new TextNode(_object.key));
            _node.set("value", new DoubleNode(_object.value));
            _node.set("remove", BooleanNode.valueOf(_object.remove));
            return _node;
        }
        public static JsonNode write(OpData _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
