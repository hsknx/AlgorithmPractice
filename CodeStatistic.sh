
echo "代码量统计"

Algorithm=$(find ./java/Algorithm/     -iname "*.java" |grep -v Test |wc -l)
DataStructure=$(find ./java/DataStructure/ -iname "*.java" |grep -v Test |wc -l)
Logic=$(find ./java/Logic/         -iname "*.java" |grep -v Test |wc -l)

AlgorithmUT=$(find ./java/UnitTest/algorithmTest     -iname "*.java" |grep  Test |wc -l)
DataStructureUT=$(find ./java/UnitTest/datastructureTest -iname "*.java" |grep  Test |wc -l)
LogicUT=$(find ./java/UnitTest/logicTest        -iname "*.java" |grep  Test |wc -l)


echo "      Algorithm/ - DataStructure/ -  Logic/"
echo "Code:    $Algorithm      -    $DataStructure          -    $Logic"
echo "UT  :    $AlgorithmUT      -    $DataStructureUT          -    $LogicUT"
