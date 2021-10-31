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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.FindCoordinatorRequestData.*;

public class FindCoordinatorRequestDataJsonConverter {
    public static FindCoordinatorRequestData read(JsonNode _node, short _version) {
        FindCoordinatorRequestData _object = new FindCoordinatorRequestData();
        JsonNode _keyNode = _node.get("key");
        if (_keyNode == null) {
            throw new RuntimeException("FindCoordinatorRequestData: unable to locate field 'key', which is mandatory in version " + _version);
        } else {
            if (!_keyNode.isTextual()) {
                throw new RuntimeException("FindCoordinatorRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.key = _keyNode.asText();
        }
        JsonNode _keyTypeNode = _node.get("keyType");
        if (_keyTypeNode == null) {
            if (_version >= 1) {
                throw new RuntimeException("FindCoordinatorRequestData: unable to locate field 'keyType', which is mandatory in version " + _version);
            } else {
                _object.keyType = (byte) 0;
            }
        } else {
            _object.keyType = MessageUtil.jsonNodeToByte(_keyTypeNode, "FindCoordinatorRequestData");
        }
        return _object;
    }
    public static JsonNode write(FindCoordinatorRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("key", new TextNode(_object.key));
        if (_version >= 1) {
            _node.set("keyType", new ShortNode(_object.keyType));
        } else {
            if (_object.keyType != (byte) 0) {
                throw new UnsupportedVersionException("Attempted to write a non-default keyType at version " + _version);
            }
        }
        return _node;
    }
    public static JsonNode write(FindCoordinatorRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
