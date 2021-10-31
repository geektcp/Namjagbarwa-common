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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.CreateAclsRequestData.*;

public class CreateAclsRequestDataJsonConverter {
    public static CreateAclsRequestData read(JsonNode _node, short _version) {
        CreateAclsRequestData _object = new CreateAclsRequestData();
        JsonNode _creationsNode = _node.get("creations");
        if (_creationsNode == null) {
            throw new RuntimeException("CreateAclsRequestData: unable to locate field 'creations', which is mandatory in version " + _version);
        } else {
            if (!_creationsNode.isArray()) {
                throw new RuntimeException("CreateAclsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<AclCreation> _collection = new ArrayList<AclCreation>(_creationsNode.size());
            _object.creations = _collection;
            for (JsonNode _element : _creationsNode) {
                _collection.add(AclCreationJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(CreateAclsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _creationsArray = new ArrayNode(JsonNodeFactory.instance);
        for (AclCreation _element : _object.creations) {
            _creationsArray.add(AclCreationJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("creations", _creationsArray);
        return _node;
    }
    public static JsonNode write(CreateAclsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AclCreationJsonConverter {
        public static AclCreation read(JsonNode _node, short _version) {
            AclCreation _object = new AclCreation();
            JsonNode _resourceTypeNode = _node.get("resourceType");
            if (_resourceTypeNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'resourceType', which is mandatory in version " + _version);
            } else {
                _object.resourceType = MessageUtil.jsonNodeToByte(_resourceTypeNode, "AclCreation");
            }
            JsonNode _resourceNameNode = _node.get("resourceName");
            if (_resourceNameNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'resourceName', which is mandatory in version " + _version);
            } else {
                if (!_resourceNameNode.isTextual()) {
                    throw new RuntimeException("AclCreation expected a string type, but got " + _node.getNodeType());
                }
                _object.resourceName = _resourceNameNode.asText();
            }
            JsonNode _resourcePatternTypeNode = _node.get("resourcePatternType");
            if (_resourcePatternTypeNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("AclCreation: unable to locate field 'resourcePatternType', which is mandatory in version " + _version);
                } else {
                    _object.resourcePatternType = (byte) 3;
                }
            } else {
                _object.resourcePatternType = MessageUtil.jsonNodeToByte(_resourcePatternTypeNode, "AclCreation");
            }
            JsonNode _principalNode = _node.get("principal");
            if (_principalNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'principal', which is mandatory in version " + _version);
            } else {
                if (!_principalNode.isTextual()) {
                    throw new RuntimeException("AclCreation expected a string type, but got " + _node.getNodeType());
                }
                _object.principal = _principalNode.asText();
            }
            JsonNode _hostNode = _node.get("host");
            if (_hostNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'host', which is mandatory in version " + _version);
            } else {
                if (!_hostNode.isTextual()) {
                    throw new RuntimeException("AclCreation expected a string type, but got " + _node.getNodeType());
                }
                _object.host = _hostNode.asText();
            }
            JsonNode _operationNode = _node.get("operation");
            if (_operationNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'operation', which is mandatory in version " + _version);
            } else {
                _object.operation = MessageUtil.jsonNodeToByte(_operationNode, "AclCreation");
            }
            JsonNode _permissionTypeNode = _node.get("permissionType");
            if (_permissionTypeNode == null) {
                throw new RuntimeException("AclCreation: unable to locate field 'permissionType', which is mandatory in version " + _version);
            } else {
                _object.permissionType = MessageUtil.jsonNodeToByte(_permissionTypeNode, "AclCreation");
            }
            return _object;
        }
        public static JsonNode write(AclCreation _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("resourceType", new ShortNode(_object.resourceType));
            _node.set("resourceName", new TextNode(_object.resourceName));
            if (_version >= 1) {
                _node.set("resourcePatternType", new ShortNode(_object.resourcePatternType));
            } else {
                if (_object.resourcePatternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default resourcePatternType at version " + _version);
                }
            }
            _node.set("principal", new TextNode(_object.principal));
            _node.set("host", new TextNode(_object.host));
            _node.set("operation", new ShortNode(_object.operation));
            _node.set("permissionType", new ShortNode(_object.permissionType));
            return _node;
        }
        public static JsonNode write(AclCreation _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
