<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>حضارة سومر</title>
<style>
:root{
  --bg:#ece0bd;
  --bg-deep:#dccb99;
  --surface:#fbf1d9;
  --surface-2:#f4e6c3;
  --ink:#3a2819;
  --ink-soft:#6b5436;
  --line:#c9ad76;
  --clay:#b5652f;
  --clay-deep:#8a481f;
  --reed:#5c7a3f;
  --reed-deep:#3f5a2a;
  --gold:#c99a2e;
  --gold-deep:#9c7418;
}
*{box-sizing:border-box;}
body{
  margin:0;
  font-family:'Tahoma','Segoe UI',sans-serif;
  background:radial-gradient(ellipse at top, var(--bg) 0%, var(--bg-deep) 100%);
  color:var(--ink);
  direction:rtl;
  padding:18px 16px 32px;
}
.page{max-width:920px;margin:0 auto;}
header{text-align:center;margin-bottom:6px;}
h1{font-size:clamp(28px,6vw,40px);margin:0;color:var(--clay-deep);letter-spacing:1px;}
.tagline{color:var(--ink-soft);font-size:13px;margin:4px 0 0;}
.era{
  margin:14px 0;text-align:center;
  background:linear-gradient(180deg,var(--gold),var(--gold-deep));
  color:#2b1d08;border-radius:10px;padding:9px 14px;font-weight:700;font-size:14px;
  border:1px solid var(--gold-deep);
}
.resource-rail{display:grid;grid-template-columns:repeat(5,1fr);gap:8px;margin-bottom:16px;}
.res{background:var(--surface);border:1px solid var(--line);border-radius:10px;padding:8px 4px;text-align:center;min-width:0;}
.res .l{font-size:11px;color:var(--ink-soft);}
.res .v{font-size:17px;font-weight:700;color:var(--clay-deep);}
.grid{display:grid;grid-template-columns:1fr;gap:14px;}
@media(min-width:720px){.grid{grid-template-columns:1.3fr 1fr;}}
.panel{background:var(--surface);border:1px solid var(--line);border-radius:14px;padding:16px;min-width:0;}
.panel h2{margin:0 0 10px;font-size:16px;color:var(--clay-deep);border-bottom:1px solid var(--line);padding-bottom:8px;}
.gather{display:grid;grid-template-columns:repeat(3,1fr);gap:8px;margin-bottom:18px;}
.gather button{background:var(--reed);border-color:var(--reed-deep);}
.gather button:hover:not(:disabled){background:var(--reed-deep);}
.buildings{display:grid;grid-template-columns:repeat(auto-fill,minmax(128px,1fr));gap:10px;}
.bcard{background:var(--surface-2);border:1px solid var(--line);border-radius:10px;padding:10px;text-align:center;}
.bcard .icon{font-size:24px;}
.bcard .name{font-weight:700;font-size:12.5px;margin:4px 0 2px;}
.bcard .count{font-size:11px;color:var(--reed-deep);margin-bottom:4px;}
.bcard .cost{font-size:11px;color:var(--ink-soft);margin-bottom:8px;}
button{
  font-family:inherit;cursor:pointer;border:1px solid var(--clay-deep);border-radius:8px;
  padding:9px 8px;font-size:13px;font-weight:700;background:var(--clay);color:#fff8e9;width:100%;
}
button:hover:not(:disabled){background:var(--clay-deep);}
button:disabled{opacity:.45;cursor:not-allowed;}
.progress-label{font-size:12.5px;color:var(--ink-soft);margin:4px 0 6px;display:flex;justify-content:space-between;}
.progress-track{background:var(--surface-2);border:1px solid var(--line);border-radius:8px;height:14px;overflow:hidden;}
.progress-fill{height:100%;background:linear-gradient(90deg,var(--gold-deep),var(--gold));width:0%;}
.log{height:220px;overflow-y:auto;background:var(--surface-2);border:1px solid var(--line);border-radius:10px;padding:4px 10px;font-size:12.5px;line-height:1.7;}
.log div{border-bottom:1px dashed var(--line);padding:5px 0;}
.log div:last-child{border-bottom:none;}
.win{position:fixed;inset:0;background:rgba(20,13,6,.82);display:none;align-items:center;justify-content:center;padding:20px;}
.win.show{display:flex;}
.win-card{background:var(--surface);border:2px solid var(--gold);border-radius:16px;padding:26px;text-align:center;max-width:380px;color:var(--ink);}
.win-card h2{font-size:22px;color:var(--clay-deep);margin:0 0 10px;}
.win-card p{font-size:13.5px;color:var(--ink-soft);line-height:1.7;margin:0 0 16px;}
</style>
</head>
<body>
<div class="page">
  <header>
    <h1>𒀭 حضارة سومر 𒀭</h1>
    <p class="tagline">ابنِ مدينتك بين دجلة والفرات، من كوخ طيني إلى زقورة شامخة</p>
  </header>

  <div class="era" id="eraBanner">العصر: قرية سومرية ناشئة</div>

  <div class="resource-rail">
    <div class="res"><div class="l">🌾 شعير</div><div class="v" id="statBarley">0</div></div>
    <div class="res"><div class="l">🧱 طين</div><div class="v" id="statClay">0</div></div>
    <div class="res"><div class="l">🪵 خشب</div><div class="v" id="statWood">0</div></div>
    <div class="res"><div class="l">👥 سكان</div><div class="v" id="statPop">0</div></div>
    <div class="res"><div class="l">⭐ مجد</div><div class="v" id="statGlory">0</div></div>
  </div>

  <div class="grid">
    <div class="panel">
      <h2>جمع الموارد</h2>
      <div class="gather">
        <button id="btnBarley">🌾 احصد شعير</button>
        <button id="btnClay">🧱 احفر طين</button>
        <button id="btnWood">🪵 اقطع خشب</button>
      </div>

      <h2>المباني</h2>
      <div class="buildings" id="buildings"></div>

      <div style="margin-top:16px;">
        <div class="progress-label">
          <span>🏗️ التقدم نحو الزقورة الكبرى</span>
          <span id="glGoal">0 / 100</span>
        </div>
        <div class="progress-track"><div class="progress-fill" id="glBar"></div></div>
      </div>
    </div>

    <div class="panel">
      <h2>سجل الأحداث</h2>
      <div class="log" id="log"></div>
    </div>
  </div>
</div>

<div class="win" id="winScreen">
  <div class="win-card">
    <h2>🏆 لقد بنيت حضارة عظيمة! 🏆</h2>
    <p>اكتملت الزقورة الكبرى، وأصبحت مدينتك منارة للحضارة بين النهرين، يُروى عنها في الألواح الطينية للأجيال القادمة.</p>
    <button id="btnRestart">ابدأ حضارة جديدة</button>
  </div>
</div>

<script>
(function(){
  const GLORY_GOAL = 100;

  function freshState(){
    return {
      barley: 10, clay: 5, wood: 5, pop: 3, glory: 0,
      buildings: {
        house:   { count:0, name:'كوخ طيني',   icon:'🏠', cost:{clay:8,wood:4},             popAdd:2, gloryAdd:0 },
        farm:    { count:0, name:'مزرعة',       icon:'🌾', cost:{wood:6,clay:4},             popAdd:0, gloryAdd:0 },
        temple:  { count:0, name:'معبد',        icon:'⛩️', cost:{clay:15,wood:10,barley:10}, popAdd:1, gloryAdd:5 },
        wall:    { count:0, name:'سور المدينة', icon:'🧱', cost:{clay:20,wood:5},            popAdd:0, gloryAdd:3 },
        ziggurat:{ count:0, name:'زقورة صغرى',  icon:'🏛️', cost:{clay:30,wood:15,barley:20}, popAdd:0, gloryAdd:10 },
      },
      logs: ['📜 بدأت رحلتك لبناء حضارة سومرية عظيمة بين دجلة والفرات...']
    };
  }

  let state = freshState();
  const logEl = document.getElementById('log');

  function log(msg){
    state.logs.unshift(msg);
    if (state.logs.length > 60) state.logs.length = 60;
    renderLog();
  }

  function renderLog(){
    logEl.innerHTML = '';
    state.logs.forEach(m => {
      const d = document.createElement('div');
      d.textContent = m;
      logEl.appendChild(d);
    });
  }

  function fmt(n){ return Math.floor(n); }

  function render(){
    document.getElementById('statBarley').textContent = fmt(state.barley);
    document.getElementById('statClay').textContent = fmt(state.clay);
    document.getElementById('statWood').textContent = fmt(state.wood);
    document.getElementById('statPop').textContent = fmt(state.pop);
    document.getElementById('statGlory').textContent = fmt(state.glory);

    const pct = Math.min(100, (state.glory / GLORY_GOAL) * 100);
    document.getElementById('glBar').style.width = pct + '%';
    document.getElementById('glGoal').textContent = fmt(state.glory) + ' / ' + GLORY_GOAL;

    let era = 'قرية سومرية ناشئة';
    if (state.glory >= 15) era = 'بلدة مزدهرة على نهر الفرات';
    if (state.glory >= 40) era = 'مدينة-دولة سومرية';
    if (state.glory >= 70) era = 'عاصمة إمبراطورية بابلية';
    if (state.glory >= GLORY_GOAL) era = 'حضارة عظيمة خالدة!';
    document.getElementById('eraBanner').textContent = 'العصر: ' + era;

    renderBuildings();
    renderLog();

    document.getElementById('winScreen').classList.toggle('show', state.glory >= GLORY_GOAL);
  }

  function canAfford(cost){
    return Object.entries(cost).every(([res, amt]) => state[res] >= amt);
  }

  function costText(cost){
    const icons = {clay:'🧱', wood:'🪵', barley:'🌾'};
    return Object.entries(cost).map(([r,a]) => `${icons[r]}${a}`).join(' · ');
  }

  function renderBuildings(){
    const wrap = document.getElementById('buildings');
    wrap.innerHTML = '';
    Object.entries(state.buildings).forEach(([key, b]) => {
      const card = document.createElement('div');
      card.className = 'bcard';
      const afford = canAfford(b.cost);
      card.innerHTML = `
        <div class="icon">${b.icon}</div>
        <div class="name">${b.name}</div>
        <div class="count">المملوك: ${b.count}</div>
        <div class="cost">${costText(b.cost)}</div>
        <button type="button" id="build-${key}" ${afford ? '' : 'disabled'}>ابنِ</button>
      `;
      wrap.appendChild(card);
      card.querySelector('button').addEventListener('click', () => build(key));
    });
  }

  function build(key){
    const b = state.buildings[key];
    if (!canAfford(b.cost)) return;
    Object.entries(b.cost).forEach(([res, amt]) => { state[res] -= amt; });
    b.count++;
    state.pop += b.popAdd;
    state.glory += b.gloryAdd;
    log(`🏗️ بنيت ${b.name}! (${b.count} الآن)`);
    render();
  }

  document.getElementById('btnBarley').addEventListener('click', () => {
    const farmBonus = state.buildings.farm.count;
    const amt = 3 + farmBonus;
    state.barley += amt;
    log(`🌾 حصدت ${amt} من الشعير.`);
    render();
  });

  document.getElementById('btnClay').addEventListener('click', () => {
    state.clay += 2;
    log('🧱 حفرت 2 من الطين على ضفاف النهر.');
    render();
  });

  document.getElementById('btnWood').addEventListener('click', () => {
    state.wood += 2;
    log('🪵 قطعت 2 من الخشب.');
    render();
  });

  document.getElementById('btnRestart').addEventListener('click', () => {
    state = freshState();
    render();
  });

  setInterval(() => {
    const upkeep = state.pop * 0.5;
    if (state.barley >= upkeep) {
      state.barley -= upkeep;
    } else {
      state.barley = 0;
      if (Math.random() < 0.3) log('⚠️ نقص في الشعير! السكان قلقون.');
    }
    render();
  }, 8000);

  log('');
  state.logs = state.logs.filter(Boolean);
  render();
})();
</script>
</body>
</html>