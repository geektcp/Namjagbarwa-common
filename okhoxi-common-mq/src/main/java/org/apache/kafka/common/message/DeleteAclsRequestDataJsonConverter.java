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
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.ArrayList;
import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DeleteAclsRequestData.*;

public class DeleteAclsRequestDataJsonConverter {
    public static DeleteAclsRequestData read(JsonNode _node, short _version) {
        DeleteAclsRequestData _object = new DeleteAclsRequestData();
        JsonNode _filtersNode = _node.get("filters");
        if (_filtersNode == null) {
            throw new RuntimeException("DeleteAclsRequestData: unable to locate field 'filters', which is mandatory in version " + _version);
        } else {
            if (!_filtersNode.isArray()) {
                throw new RuntimeException("DeleteAclsRequestData expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<DeleteAclsFilter> _collection = new ArrayList<DeleteAclsFilter>(_filtersNode.size());
            _object.filters = _collection;
            for (JsonNode _element : _filtersNode) {
                _collection.add(DeleteAclsFilterJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(DeleteAclsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        ArrayNode _filtersArray = new ArrayNode(JsonNodeFactory.instance);
        for (DeleteAclsFilter _element : _object.filters) {
            _filtersArray.add(DeleteAclsFilterJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("filters", _filtersArray);
        return _node;
    }
    public static JsonNode write(DeleteAclsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DeleteAclsFilterJsonConverter {
        public static DeleteAclsFilter read(JsonNode _node, short _version) {
            DeleteAclsFilter _object = new DeleteAclsFilter();
            JsonNode _resourceTypeFilterNode = _node.get("resourceTypeFilter");
            if (_resourceTypeFilterNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'resourceTypeFilter', which is mandatory in version " + _version);
            } else {
                _object.resourceTypeFilter = MessageUtil.jsonNodeToByte(_resourceTypeFilterNode, "DeleteAclsFilter");
            }
            JsonNode _resourceNameFilterNode = _node.get("resourceNameFilter");
            if (_resourceNameFilterNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'resourceNameFilter', which is mandatory in version " + _version);
            } else {
                if (_resourceNameFilterNode.isNull()) {
                    _object.resourceNameFilter = null;
                } else {
                    if (!_resourceNameFilterNode.isTextual()) {
                        throw new RuntimeException("DeleteAclsFilter expected a string type, but got " + _node.getNodeType());
                    }
                    _object.resourceNameFilter = _resourceNameFilterNode.asText();
                }
            }
            JsonNode _patternTypeFilterNode = _node.get("patternTypeFilter");
            if (_patternTypeFilterNode == null) {
                if (_version >= 1) {
                    throw new RuntimeException("DeleteAclsFilter: unable to locate field 'patternTypeFilter', which is mandatory in version " + _version);
                } else {
                    _object.patternTypeFilter = (byte) 3;
                }
            } else {
                _object.patternTypeFilter = MessageUtil.jsonNodeToByte(_patternTypeFilterNode, "DeleteAclsFilter");
            }
            JsonNode _principalFilterNode = _node.get("principalFilter");
            if (_principalFilterNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'principalFilter', which is mandatory in version " + _version);
            } else {
                if (_principalFilterNode.isNull()) {
                    _object.principalFilter = null;
                } else {
                    if (!_principalFilterNode.isTextual()) {
                        throw new RuntimeException("DeleteAclsFilter expected a string type, but got " + _node.getNodeType());
                    }
                    _object.principalFilter = _principalFilterNode.asText();
                }
            }
            JsonNode _hostFilterNode = _node.get("hostFilter");
            if (_hostFilterNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'hostFilter', which is mandatory in version " + _version);
            } else {
                if (_hostFilterNode.isNull()) {
                    _object.hostFilter = null;
                } else {
                    if (!_hostFilterNode.isTextual()) {
                        throw new RuntimeException("DeleteAclsFilter expected a string type, but got " + _node.getNodeType());
                    }
                    _object.hostFilter = _hostFilterNode.asText();
                }
            }
            JsonNode _operationNode = _node.get("operation");
            if (_operationNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'operation', which is mandatory in version " + _version);
            } else {
                _object.operation = MessageUtil.jsonNodeToByte(_operationNode, "DeleteAclsFilter");
            }
            JsonNode _permissionTypeNode = _node.get("permissionType");
            if (_permissionTypeNode == null) {
                throw new RuntimeException("DeleteAclsFilter: unable to locate field 'permissionType', which is mandatory in version " + _version);
            } else {
                _object.permissionType = MessageUtil.jsonNodeToByte(_permissionTypeNode, "DeleteAclsFilter");
            }
            return _object;
        }
        public static JsonNode write(DeleteAclsFilter _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("resourceTypeFilter", new ShortNode(_object.resourceTypeFilter));
            if (_object.resourceNameFilter == null) {
                _node.set("resourceNameFilter", NullNode.instance);
            } else {
                _node.set("resourceNameFilter", new TextNode(_object.resourceNameFilter));
            }
            if (_version >= 1) {
                _node.set("patternTypeFilter", new ShortNode(_object.patternTypeFilter));
            } else {
                if (_object.patternTypeFilter != (byte) 3) {
                    throw new UnsupportedVersionException("Attempted to write a non-default patternTypeFilter at version " + _version);
                }
            }
            if (_object.principalFilter == null) {
                _node.set("principalFilter", NullNode.instance);
            } else {
                _node.set("principalFilter", new TextNode(_object.principalFilter));
            }
            if (_object.hostFilter == null) {
                _node.set("hostFilter", NullNode.instance);
            } else {
                _node.set("hostFilter", new TextNode(_object.hostFilter));
            }
            _node.set("operation", new ShortNode(_object.operation));
            _node.set("permissionType", new ShortNode(_object.permissionType));
            return _node;
        }
        public static JsonNode write(DeleteAclsFilter _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
