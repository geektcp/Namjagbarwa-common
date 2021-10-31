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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;

import static org.apache.kafka.common.message.DescribeDelegationTokenRequestData.*;

public class DescribeDelegationTokenRequestDataJsonConverter {
    public static DescribeDelegationTokenRequestData read(JsonNode _node, short _version) {
        DescribeDelegationTokenRequestData _object = new DescribeDelegationTokenRequestData();
        JsonNode _ownersNode = _node.get("owners");
        if (_ownersNode == null) {
            throw new RuntimeException("DescribeDelegationTokenRequestData: unable to locate field 'owners', which is mandatory in version " + _version);
        } else {
            if (_ownersNode.isNull()) {
                _object.owners = null;
            } else {
                if (!_ownersNode.isArray()) {
                    throw new RuntimeException("DescribeDelegationTokenRequestData expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<DescribeDelegationTokenOwner> _collection = new ArrayList<DescribeDelegationTokenOwner>(_ownersNode.size());
                _object.owners = _collection;
                for (JsonNode _element : _ownersNode) {
                    _collection.add(DescribeDelegationTokenOwnerJsonConverter.read(_element, _version));
                }
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeDelegationTokenRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_object.owners == null) {
            _node.set("owners", NullNode.instance);
        } else {
            ArrayNode _ownersArray = new ArrayNode(JsonNodeFactory.instance);
            for (DescribeDelegationTokenOwner _element : _object.owners) {
                _ownersArray.add(DescribeDelegationTokenOwnerJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("owners", _ownersArray);
        }
        return _node;
    }
    public static JsonNode write(DescribeDelegationTokenRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribeDelegationTokenOwnerJsonConverter {
        public static DescribeDelegationTokenOwner read(JsonNode _node, short _version) {
            DescribeDelegationTokenOwner _object = new DescribeDelegationTokenOwner();
            JsonNode _principalTypeNode = _node.get("principalType");
            if (_principalTypeNode == null) {
                throw new RuntimeException("DescribeDelegationTokenOwner: unable to locate field 'principalType', which is mandatory in version " + _version);
            } else {
                if (!_principalTypeNode.isTextual()) {
                    throw new RuntimeException("DescribeDelegationTokenOwner expected a string type, but got " + _node.getNodeType());
                }
                _object.principalType = _principalTypeNode.asText();
            }
            JsonNode _principalNameNode = _node.get("principalName");
            if (_principalNameNode == null) {
                throw new RuntimeException("DescribeDelegationTokenOwner: unable to locate field 'principalName', which is mandatory in version " + _version);
            } else {
                if (!_principalNameNode.isTextual()) {
                    throw new RuntimeException("DescribeDelegationTokenOwner expected a string type, but got " + _node.getNodeType());
                }
                _object.principalName = _principalNameNode.asText();
            }
            return _object;
        }
        public static JsonNode write(DescribeDelegationTokenOwner _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("principalType", new TextNode(_object.principalType));
            _node.set("principalName", new TextNode(_object.principalName));
            return _node;
        }
        public static JsonNode write(DescribeDelegationTokenOwner _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
