using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using USB_Web.Models;

namespace USB_Web.Controllers
{
    public class HomeController : Controller
    {
        public kunde loggedInUser = null;
        public int kundeNr;
        private USBEntities db = new USBEntities();
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
        
        public ActionResult OrderPage(kunde loggedInUser)
        {
            this.kundeNr = loggedInUser.KundeNummer;
            ViewBag.Message = this.loggedInUser;
            if (loggedInUser != null)
            {
                
                var items = from c in db.produkter select c;
                return View(items);
            }

            return RedirectToAction("Index");
        }
        [HttpPost]
        public ActionResult OrderPage(produkter pro)
        {
            //(ModelState.IsValid)
            //{
                var pr = pro.ProduktID;
                var kn = this.kundeNr;
                db.udlejning.Add(new udlejning
                {
                    KundeNr = kn,
                    PID = pr,
                    ProduktStatus = "Reserveret",
                    Afhentningstidspunkt = "Temp",
                    AntalDoegn = 0
                });
                db.SaveChanges();
            //}
            
            return RedirectToAction("OrderPage", this.loggedInUser);
        }
    }
}