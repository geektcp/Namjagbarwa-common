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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreateDelegationTokenRequestData.*;

public class CreateDelegationTokenRequestDataJsonConverter {
    public static CreateDelegationTokenRequestData read(JsonNode _node, short _version) {
        CreateDelegationTokenRequestData _object = new CreateDelegationTokenRequestData();
        JsonNode _renewersNode = _node.get("renewers");
        if (_renewersNode == null) {
            throw new RuntimeException("CreateDelegationTokenRequestData: unable to locate field 'renewers', which is mandatory in version " + _version);
        } else {
            if (!_renewersNode.isArray()) {
                throw new RuntimeException("CreateDelegationTokenRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<CreatableRenewers> _collection = new ArrayList<CreatableRenewers>(_renewersNode.size());
            _object.renewers = _collection;
            for (JsonNode _element : _renewersNode) {
                _collection.add(CreatableRenewersJsonConverter.read(_element, _version));
            }
        }
        JsonNode _maxLifetimeMsNode = _node.get("maxLifetimeMs");
        if (_maxLifetimeMsNode == null) {
            throw new RuntimeException("CreateDelegationTokenRequestData: unable to locate field 'maxLifetimeMs', which is mandatory in version " + _version);
        } else {
            _object.maxLifetimeMs = MessageUtil.jsonNodeToLong(_maxLifetimeMsNode, "CreateDelegationTokenRequestData");
        }
        return _object;
    }
    public static JsonNode write(CreateDelegationTokenRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _renewersArray = new ArrayNode(JsonNodeFactory.instance);
        for (CreatableRenewers _element : _object.renewers) {
            _renewersArray.add(CreatableRenewersJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("renewers", _renewersArray);
        _node.set("maxLifetimeMs", new LongNode(_object.maxLifetimeMs));
        return _node;
    }
    public static JsonNode write(CreateDelegationTokenRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class CreatableRenewersJsonConverter {
        public static CreatableRenewers read(JsonNode _node, short _version) {
            CreatableRenewers _object = new CreatableRenewers();
            JsonNode _principalTypeNode = _node.get("principalType");
            if (_principalTypeNode == null) {
                throw new RuntimeException("CreatableRenewers: unable to locate field 'principalType', which is mandatory in version " + _version);
            } else {
                if (!_principalTypeNode.isTextual()) {
                    throw new RuntimeException("CreatableRenewers expected a string type, but got " + _node.getNodeType());
                }
                _object.principalType = _principalTypeNode.asText();
            }
            JsonNode _principalNameNode = _node.get("principalName");
            if (_principalNameNode == null) {
                throw new RuntimeException("CreatableRenewers: unable to locate field 'principalName', which is mandatory in version " + _version);
            } else {
                if (!_principalNameNode.isTextual()) {
                    throw new RuntimeException("CreatableRenewers expected a string type, but got " + _node.getNodeType());
                }
                _object.principalName = _principalNameNode.asText();
            }
            return _object;
        }
        public static JsonNode write(CreatableRenewers _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("principalType", new TextNode(_object.principalType));
            _node.set("principalName", new TextNode(_object.principalName));
            return _node;
        }
        public static JsonNode write(CreatableRenewers _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
