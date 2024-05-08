/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.service.pkg.tosca.vnf.mapping;

import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;
import com.ubiqube.etsi.mano.dao.mano.vim.VnfStorage;
import com.ubiqube.parser.tosca.Artifact;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.vdu.VirtualBlockStorage;
import com.ubiqube.parser.tosca.scalar.Size;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VirtualBlockStorageMapping {

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "size", source = "virtualBlockStorageData.sizeOfStorage")
	@Mapping(target = "softwareImage", source = "artifacts")
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "toscaId", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "type", constant = "BLOCK")
	@Mapping(target = "vnfPackage", ignore = true)
	VnfStorage map(VirtualBlockStorage vs);

	default SoftwareImage map(final Map<String, Artifact> o) {
		if ((null == o) || o.isEmpty()) {
			return null;
		}
		final Artifact a = o.values().iterator().next();
		return map(a);
	}

	default long map(final Size value) {
		return value.getValue().longValue();
	}

	@Mapping(target = "userMetadata", ignore = true)
	@Mapping(target = "architecture", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "checksum", ignore = true)
	@Mapping(target = "containerFormat", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "diskFormat", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "imagePath", ignore = true)
	@Mapping(target = "imageUri", ignore = true)
	@Mapping(target = "isEncrypted", ignore = true)
	@Mapping(target = "minDisk", ignore = true)
	@Mapping(target = "minRam", ignore = true)
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "nfvoPath", ignore = true)
	@Mapping(target = "provider", ignore = true)
	@Mapping(target = "size", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	SoftwareImage map(Artifact art);
}
