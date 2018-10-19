package me.sumithpuri.github.pattaya.facade;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Blog Post URL		http://www.techilashots.com/2008/12/design-patterns-series-ii.html
 * Blog Short URL		https://goo.gl/XCc2gx
 * Package Prefix 		me.sumithpuri.github.pattaya
 * Project Codename		pattaya
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class InvoiceSessionFacadeImpl implements InvoiceSessionFacade {

	// This is only for the example, Do not follow 
	// this kind of initialisation in your code
	
	OrderManager orderManager = new OrderManager();
	LedgerManager ledgerManager = new LedgerManager();
	BillingManager billingManager = new BillingManager();
	
	
	@Override
	public void addInvoice(Invoice invoice) {
	
		orderManager.initOnInvoice(invoice.getInvoiceId());
		ledgerManager.initOnInvoice(invoice.getInvoiceId());
		billingManager.initOnInvoice(invoice.getInvoiceId());
	}

	@Override
	public void deleteInvoice(Invoice invoice) {
		
		orderManager.purgeInvoice(invoice.getInvoiceId());
		ledgerManager.cascadeDeleteInvoice(invoice.getInvoiceId());
		billingManager.deleteInvoice(invoice.getInvoiceId());
	}

}