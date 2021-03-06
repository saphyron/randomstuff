// <copyright file="CalculatorTest.cs">Copyright ©  2020</copyright>
using System;
using Microsoft.Pex.Framework;
using Microsoft.Pex.Framework.Validation;
using NUnit.Framework;
using UnitTestConsoleApp;

namespace UnitTestConsoleApp.Tests
{
    /// <summary>This class contains parameterized unit tests for Calculator</summary>
    [PexClass(typeof(Calculator))]
    [PexAllowedExceptionFromTypeUnderTest(typeof(InvalidOperationException))]
    [PexAllowedExceptionFromTypeUnderTest(typeof(ArgumentException), AcceptExceptionSubtypes = true)]
    [TestFixture]
    public partial class CalculatorTest
    {
        /// <summary>Test stub for substract(Int32, Int32)</summary>
        [PexMethod]
        public int substractTest(
            [PexAssumeUnderTest]Calculator target,
            int a,
            int b
        )
        {
            int result = target.substract(a, b);
            return result;
            // TODO: add assertions to method CalculatorTest.substractTest(Calculator, Int32, Int32)
        }
    }
}
