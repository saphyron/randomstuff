﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Eksamensopgave_WEB.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        [HttpGet]
        public ActionResult Login()
        {
            ViewBag.Message = "Login her";

            return View();
        }

        [HttpPost]
        public ActionResult Login(kunde kunde)
        {
            ViewBag.Message = "Login her";
            this.loggedInUser = db.kunde.FirstOrDefault(k =>
            k.Brugernavn.Equals(kunde.Brugernavn) &&
            k.Password.Equals(kunde.Password));

            return RedirectToAction("OrderPage", loggedInUser);
        }
    }
}