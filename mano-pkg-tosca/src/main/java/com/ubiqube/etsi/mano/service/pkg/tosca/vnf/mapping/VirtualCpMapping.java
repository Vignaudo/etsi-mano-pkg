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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.pkg.AdditionalServiceData;
import com.ubiqube.etsi.mano.dao.mano.pkg.ServicePortData;
import com.ubiqube.etsi.mano.dao.mano.vim.VlProtocolData;
import com.ubiqube.parser.tosca.objects.tosca.datatypes.nfv.CpProtocolData;
import com.ubiqube.parser.tosca.objects.tosca.datatypes.nfv.ServiceData;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.VirtualCp;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VirtualCpMapping {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "targetRef", ignore = true)
	@Mapping(target = "virtualLinkRef", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.pkg.VirtualCp mapToVirtualCp(final VirtualCp x);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ipAllocationPools", ignore = true)
	@Mapping(target = "l2ProtocolData", ignore = true)
	@Mapping(target = "l3ProtocolData", ignore = true)
	VlProtocolData mapToVlProtocolData(CpProtocolData o);

	@Mapping(target = "id", ignore = true)
	AdditionalServiceData mapToAdditionalServiceData(com.ubiqube.parser.tosca.objects.tosca.datatypes.nfv.AdditionalServiceData o);

	@Mapping(target = "id", ignore = true)
	ServicePortData mapToServicePortData(com.ubiqube.parser.tosca.objects.tosca.datatypes.nfv.ServicePortData o);

	default String toString(final ServiceData serviceData) {
		if (null == serviceData) {
			return null;
		}
		return serviceData.getHost();
	}
}
