using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace UnitTestConsoleApp
{
    [TestFixture]
    class TestClass
    {
        Calculator calc;

        [SetUp]
        public void SetUp()
        {
            calc = new Calculator();
        }

        [Test]
        public void SubstractTest()
        {
            Assert.AreEqual(-2, calc.substract(4, 6));
        }

        [TestCase(10, 4, 6)]
        [TestCase(16, 10, 6)]
        public void SumTest(int result, int v1, int v2)
        {
            Assert.That(calc.add(v1, v2), Is.EqualTo(result));
        }

        [Test]
        public void DivisionTest()
        {
            Assert.Throws<DivideByZeroException>(() => calc.divexcep(4, 0));
        }

        [TestCase(1, 4, 4)]
        [TestCase(5, 10, 2)]
        [TestCase(2.5, 5, 2)]
        public void DivTest(double result, double v1, double v2)
        {
            Assert.That(calc.div(v1, v2), Is.EqualTo(result));
        }

        [TestCase(16, 4, 4)]
        [TestCase(20, 10, 2)]
        [TestCase(6.6, 3.3, 2)]
        public void MultiplyTest(double result, double v1, double v2)
        {
            Assert.That(calc.mult(v1, v2), Is.EqualTo(result));
        }

        [TestCase("10101910-0202", "101010", "0202")]
        [TestCase("10102010-0242", "101010", "0242")]
        [TestCase("10101938-3842", "101038", "3842")]
        [TestCase("10102010-0252", "101010", "0252")]
        [TestCase("10101858-5952", "101058", "5952")]
        [TestCase("10102010-0292", "101010", "0292")]
        [TestCase("10101938-3892", "101038", "3892")]
        public void CprTest(string result, string c1, string c2)
        {
            Assert.That(calc.Cpr(c1, c2), Is.EqualTo(result));
        }
    }
}
