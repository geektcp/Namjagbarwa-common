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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import static org.apache.kafka.common.message.DefaultPrincipalData.*;

public class DefaultPrincipalDataJsonConverter {
    public static DefaultPrincipalData read(JsonNode _node, short _version) {
        DefaultPrincipalData _object = new DefaultPrincipalData();
        JsonNode _typeNode = _node.get("type");
        if (_typeNode == null) {
            throw new RuntimeException("DefaultPrincipalData: unable to locate field 'type', which is mandatory in version " + _version);
        } else {
            if (!_typeNode.isTextual()) {
                throw new RuntimeException("DefaultPrincipalData expected a string type, but got " + _node.getNodeType());
            }
            _object.type = _typeNode.asText();
        }
        JsonNode _nameNode = _node.get("name");
        if (_nameNode == null) {
            throw new RuntimeException("DefaultPrincipalData: unable to locate field 'name', which is mandatory in version " + _version);
        } else {
            if (!_nameNode.isTextual()) {
                throw new RuntimeException("DefaultPrincipalData expected a string type, but got " + _node.getNodeType());
            }
            _object.name = _nameNode.asText();
        }
        JsonNode _tokenAuthenticatedNode = _node.get("tokenAuthenticated");
        if (_tokenAuthenticatedNode == null) {
            throw new RuntimeException("DefaultPrincipalData: unable to locate field 'tokenAuthenticated', which is mandatory in version " + _version);
        } else {
            if (!_tokenAuthenticatedNode.isBoolean()) {
                throw new RuntimeException("DefaultPrincipalData expected Boolean type, but got " + _node.getNodeType());
            }
            _object.tokenAuthenticated = _tokenAuthenticatedNode.asBoolean();
        }
        return _object;
    }
    public static JsonNode write(DefaultPrincipalData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("type", new TextNode(_object.type));
        _node.set("name", new TextNode(_object.name));
        _node.set("tokenAuthenticated", BooleanNode.valueOf(_object.tokenAuthenticated));
        return _node;
    }
    public static JsonNode write(DefaultPrincipalData _object, short _version) {
        return write(_object, _version, true);
    }
}
