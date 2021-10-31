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
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeAclsResponseData.*;

public class DescribeAclsResponseDataJsonConverter {
    public static DescribeAclsResponseData read(JsonNode _node, short _version) {
        DescribeAclsResponseData _object = new DescribeAclsResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeAclsResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeAclsResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("DescribeAclsResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeAclsResponseData");
        }
        JsonNode _errorMessageNode = _node.get("errorMessage");
        if (_errorMessageNode == null) {
            throw new RuntimeException("DescribeAclsResponseData: unable to locate field 'errorMessage', which is mandatory in version " + _version);
        } else {
            if (_errorMessageNode.isNull()) {
                _object.errorMessage = null;
            } else {
                if (!_errorMessageNode.isTextual()) {
                    throw new RuntimeException("DescribeAclsResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.errorMessage = _errorMessageNode.asText();
            }
        }
        JsonNode _resourcesNode = _node.get("resources");
        if (_resourcesNode == null) {
            throw new RuntimeException("DescribeAclsResponseData: unable to locate field 'resources', which is mandatory in version " + _version);
        } else {
            if (!_resourcesNode.isArray()) {
                throw new RuntimeException("DescribeAclsResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DescribeAclsResource> _collection = new ArrayList<DescribeAclsResource>(_resourcesNode.size());
            _object.resources = _collection;
            for (JsonNode _element : _resourcesNode) {
                _collection.add(DescribeAclsResourceJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DescribeAclsResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_object.errorMessage == null) {
            _node.set("errorMessage", NullNode.instance);
        } else {
            _node.set("errorMessage", new TextNode(_object.errorMessage));
        }
        ArrayNode _resourcesArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeAclsResource _element : _object.resources) {
            _resourcesArray.add(DescribeAclsResourceJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("resources", _resourcesArray);
        return _node;
    }
    public static JsonNode write(DescribeAclsResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class AclDescriptionJsonConverter {
        public static AclDescription read(JsonNode _node, short _version) {
            AclDescription _object = new AclDescription();
            JsonNode _principalNode = _node.get("principal");
            if (_principalNode == null) {
                throw new RuntimeException("AclDescription: unable to locate field 'principal', which is mandatory in version " + _version);
            } else {
                if (!_principalNode.isTextual()) {
                    throw new RuntimeException("AclDescription expected a string type, but got " + _node.getNodeType());
                }
                _object.principal = _principalNode.asText();
            }
            JsonNode _hostNode = _node.get("host");
            if (_hostNode == null) {
                throw new RuntimeException("AclDescription: unable to locate field 'host', which is mandatory in version " + _version);
            } else {
                if (!_hostNode.isTextual()) {
                    throw new RuntimeException("AclDescription expected a string type, but got " + _node.getNodeType());
                }
                _object.host = _hostNode.asText();
            }
            JsonNode _operationNode = _node.get("operation");
            if (_operationNode == null) {
                throw new RuntimeException("AclDescription: unable to locate field 'operation', which is mandatory in version " + _version);
            } else {
                _object.operation = MessageUtil.jsonNodeToByte(_operationNode, "AclDescription");
            }
            JsonNode _permissionTypeNode = _node.get("permissionType");
            if (_permissionTypeNode == null) {
                throw new RuntimeException("AclDescription: unable to locate field 'permissionType', which is mandatory in version " + _version);
            } else {
                _object.permissionType = MessageUtil.jsonNodeToByte(_permissionTypeNode, "AclDescription");
            }
            return _object;
        }
        public static JsonNode write(AclDescription _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("principal", new TextNode(_object.principal));
            _node.set("host", new TextNode(_object.host));
            _node.set("operation", new ShortNode(_object.operation));
            _node.set("permissionType", new ShortNode(_object.permissionType));
            return _node;
        }
        public static JsonNode write(AclDescription _object, short _version) {
            return write(_object, _version, true);
        }
    }
    
    public static class DescribeAclsResourceJsonConverter {
        public static DescribeAclsResource read(JsonNode _node, short _version) {
            DescribeAclsResource _object = new DescribeAclsResource();
            JsonNode _resourceTypeNode = _node.get("resourceType");
            if (_resourceTypeNode == null) {
                throw new RuntimeException("DescribeAclsResource: unable to locate field 'resourceType', which is mandatory in version " + _version);
            } else {
                _object.resourceType = MessageUtil.jsonNodeToByte(_resourceTypeNode, "DescribeAclsResource");
            }
            JsonNode _resourceNameNode = _node.get("resourceName");
            if (_resourceNameNode == null) {
                throw new RuntimeException("DescribeAclsResource: unable to locate field 'resourceName', which is mandatory in version " + _version);
            } else {
                if (!_resourceNameNode.isTextual()) {
                    throw new RuntimeException("DescribeAclsResource expected a string type, but got " + _node.getNodeType());
                }
                _object.resourceName = _resourceNameNode.asText();
            }
            JsonNode _patternTypeNode = _node.get("patternType");
            if (_patternTypeNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("DescribeAclsResource: unable to locate field 'patternType', which is mandatory in version " + _version);
                } else {
                    _object.patternType = (byte) 3;
                }
            } else {
                _object.patternType = MessageUtil.jsonNodeToByte(_patternTypeNode, "DescribeAclsResource");
            }
            JsonNode _aclsNode = _node.get("acls");
            if (_aclsNode == null) {
                throw new RuntimeException("DescribeAclsResource: unable to locate field 'acls', which is mandatory in version " + _version);
            } else {
                if (!_aclsNode.isArray()) {
                    throw new RuntimeException("DescribeAclsResource expected a JSON array, but got " + _node.getNodeType());
                }
                ArrayList<AclDescription> _collection = new ArrayList<AclDescription>(_aclsNode.size());
                _object.acls = _collection;
                for (JsonNode _element : _aclsNode) {
                    _collection.add(AclDescriptionJsonConverter.read(_element, _version));
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeAclsResource _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("resourceType", new ShortNode(_object.resourceType));
            _node.set("resourceName", new TextNode(_object.resourceName));
            if (_version >= 1) {
                _node.set("patternType", new ShortNode(_object.patternType));
            } else {
                if (_object.patternType != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default patternType at version " + _version);
                }
            }
            ArrayNode _aclsArray = new ArrayNode(JsonNodeFactory.instance);
            for (AclDescription _element : _object.acls) {
                _aclsArray.add(AclDescriptionJsonConverter.write(_element, _version, _serializeRecords));
            }
            _node.set("acls", _aclsArray);
            return _node;
        }
        public static JsonNode write(DescribeAclsResource _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
