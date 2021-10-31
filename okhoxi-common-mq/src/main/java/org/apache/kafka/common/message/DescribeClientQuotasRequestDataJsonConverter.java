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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeClientQuotasRequestData.*;

public class DescribeClientQuotasRequestDataJsonConverter {
    public static DescribeClientQuotasRequestData read(JsonNode _node, short _version) {
        DescribeClientQuotasRequestData _object = new DescribeClientQuotasRequestData();
        JsonNode _componentsNode = _node.get("components");
        if (_componentsNode == null) {
            throw new RuntimeException("DescribeClientQuotasRequestData: unable to locate field 'components', which is mandatory in version " + _version);
        } else {
            if (!_componentsNode.isArray()) {
                throw new RuntimeException("DescribeClientQuotasRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<ComponentData> _collection = new ArrayList<ComponentData>(_componentsNode.size());
            _object.components = _collection;
            for (JsonNode _element : _componentsNode) {
                _collection.add(ComponentDataJsonConverter.read(_element, _version));
            }
        }
        JsonNode _strictNode = _node.get("strict");
        if (_strictNode == null) {
            throw new RuntimeException("DescribeClientQuotasRequestData: unable to locate field 'strict', which is mandatory in version " + _version);
        } else {
            if (!_strictNode.isBoolean()) {
                throw new RuntimeException("DescribeClientQuotasRequestData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.strict = _strictNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(DescribeClientQuotasRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _componentsArray = new ArrayNode(JsonNodeFactory.instance);
        for (ComponentData _element : _object.components) {
            _componentsArray.add(ComponentDataJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("components", _componentsArray);
        _node.set("strict", BooleanNode.valueOf(_object.strict));
        return _node;
    }
    public static JsonNode write(DescribeClientQuotasRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class ComponentDataJsonConverter {
        public static ComponentData read(JsonNode _node, short _version) {
            ComponentData _object = new ComponentData();
            JsonNode _entityTypeNode = _node.get("entityType");
            if (_entityTypeNode == null) {
                throw new RuntimeException("ComponentData: unable to locate field 'entityType', which is mandatory in version " + _version);
            } else {
                if (!_entityTypeNode.isTextual()) {
                    throw new RuntimeException("ComponentData expected a string type, but got " + _node.getNodeType());
                }
                _object.entityType = _entityTypeNode.asText();
            }
            JsonNode _matchTypeNode = _node.get("matchType");
            if (_matchTypeNode == null) {
                throw new RuntimeException("ComponentData: unable to locate field 'matchType', which is mandatory in version " + _version);
            } else {
                _object.matchType = MessageUtil.jsonNodeToByte(_matchTypeNode, "ComponentData");
            }
            JsonNode _matchNode = _node.get("match");
            if (_matchNode == null) {
                throw new RuntimeException("ComponentData: unable to locate field 'match', which is mandatory in version " + _version);
            } else {
                if (_matchNode.isNull()) {
                    _object.match = null;
                } else {
                    if (!_matchNode.isTextual()) {
                        throw new RuntimeException("ComponentData expected a string type, but got " + _node.getNodeType());
                    }
                    _object.match = _matchNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(ComponentData _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("entityType", new TextNode(_object.entityType));
            _node.set("matchType", new ShortNode(_object.matchType));
            if (_object.match == null) {
                _node.set("match", NullNode.instance);
            } else {
                _node.set("match", new TextNode(_object.match));
            }
            return _node;
        }
        public static JsonNode write(ComponentData _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
