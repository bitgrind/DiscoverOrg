import { DiscoverOrgAppPage } from './app.po';

describe('discover-org-app App', () => {
  let page: DiscoverOrgAppPage;

  beforeEach(() => {
    page = new DiscoverOrgAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
