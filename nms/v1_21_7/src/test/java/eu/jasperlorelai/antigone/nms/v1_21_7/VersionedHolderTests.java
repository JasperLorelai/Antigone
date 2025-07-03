package eu.jasperlorelai.antigone.nms.v1_21_7;

import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import eu.jasperlorelai.antigone.nms.shared.util.AntigoneTests;

public class VersionedHolderTests extends AntigoneTests {

	@Override
	@TestFactory
	protected List<DynamicTest> test() {
		return versionedHolderTests();
	}

}
